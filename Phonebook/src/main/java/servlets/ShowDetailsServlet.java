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
 * Shows details about selected contact. If there's no active user's session,
 * redirects to home servlet.
 *
 * @author Grzegorz Kossowski
 * @version 1.0
 */
@WebServlet(
        name = "showDetailsServlet",
        urlPatterns = {"/showDetails"}
)
public class ShowDetailsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }
        /*
        // If using Glassfish, must work with JdbcUtil class. 
        // At this moment Glassfish & Hibernate & JEE don't cooperate well.
        Person person = JdbcUtil.getPerson(request.getParameter("id"));
         */
        Person person = HibernateUtil.getPerson(request.getParameter("id"));
        request.setAttribute("person", person);
        request.getRequestDispatcher("/WEB-INF/jsp/view/showDetails.jsp").forward(request, response);

    }

}
