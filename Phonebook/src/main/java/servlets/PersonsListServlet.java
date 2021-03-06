package servlets;

import beans.Person;
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
 * Gets from DB and displays full list of contacts.
 *
 * @author Grzegorz Kossowski
 * @version 1.0
 */
@WebServlet(
        name = "personsListServlet",
        urlPatterns = {"/listPerson"}
)
public class PersonsListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        /*
        // If using Glassfish, must work with JdbcUtil class. 
        // At this moment Glassfish & Hibernate & JEE don't cooperate well.
        String sql = "SELECT * FROM person ORDER BY lastname";
        List<Person> persons = JdbcUtil.getPersons(sql);
         */
        String sql = "FROM Person ORDER BY lastname";
        List<Person> persons = HibernateUtil.getPersons(sql);

        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/WEB-INF/jsp/view/list.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
