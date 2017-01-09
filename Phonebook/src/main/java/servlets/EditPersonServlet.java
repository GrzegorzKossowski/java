package servlets;

import beans.Person;
import hibernate.HibernateUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Gets contact from DB and displays it in jsp form.
 *
 * @author Grzegorz Kossowski
 * @version 1.0
 */
@WebServlet(
        name = "editPersonServlet",
        urlPatterns = {"/editPerson"}
)
public class EditPersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        String id = request.getParameter("id");
        /*
        // If using Glassfish, must work with JdbcUtil class. 
        // At this moment Glassfish & Hibernate & JEE don't cooperate well.
        Person person = JdbcUtil.getPerson(id);
         */
        Person person = HibernateUtil.getPerson(id);

        request.setAttribute("person", person);
        request.getRequestDispatcher("WEB-INF/jsp/view/editPerson.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
