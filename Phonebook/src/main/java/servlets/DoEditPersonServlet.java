package servlets;

import beans.Person;
import com.mysql.jdbc.StringUtils;
import hibernate.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Adds edited contact to DB.
 *
 * @author Grzegorz Kossowski
 * @version 1.0
 */
@WebServlet(
        name = "doEditPersonServlet",
        urlPatterns = {"/doEditPerson"}
)
public class DoEditPersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //resolving polish diactric marks
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        boolean isError = false;
        // message to display in jsp form
        String errorMsg = "";

        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");

        Person person = new Person(id, firstName, lastName, phone, mobile, email);

        //checking f-name and l-name only, assuming that person can have no phone numbers or email
        if (StringUtils.isEmptyOrWhitespaceOnly(firstName) || StringUtils.isEmptyOrWhitespaceOnly(lastName)) {
            isError = true;
            errorMsg = "First name or last name can't be empty";
        }

        if (isError) {
            request.setAttribute("errorMsg", errorMsg);
            request.setAttribute("person", person);
            request.getRequestDispatcher("/WEB-INF/jsp/view/editPerson.jsp").forward(request, response);
        } else {
            /*
            // If using Glassfish, must work with JdbcUtil class. 
            // At this moment Glassfish & Hibernate & JEE don't cooperate well.
            JdbcUtil.updatePerson(person);
             */
            HibernateUtil.updatePerson(person);

            // update last search cache
            if (session.getAttribute("lastSearch") != null) {
                /*
                // If using Glassfish, must work with JdbcUtil class. 
                // At this moment Glassfish & Hibernate & JEE don't cooperate well.
                persons = JdbcUtil.getPersons(sql);
                 */
                String sql = (String) session.getAttribute("lastQuery");
                List<Person> lastPersons = HibernateUtil.getPersons(sql);
                session.setAttribute("lastSearch", lastPersons);
            }

            response.sendRedirect(request.getContextPath() + "/listPerson");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
