package servlets;

import beans.Person;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.JdbcUtil;

/**
 *
 * @author grze
 */
@WebServlet(
        name = "doAddPerson",
        urlPatterns = "/doAddPerson"
)
public class DoAddPersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        boolean dbError = true;
        
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        
        Person person = new Person(firstname, lastname, phone, mobile, email);
        
        dbError = JdbcUtil.savePerson(person);

        if (dbError) {
            request.getRequestDispatcher("/WEB-INF/jsp/view/errorAddPerson.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/view/confirmAddPerson.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}