package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.JdbcUtil;

/**
 * Removes contact from database and redirects to contacts list.
 * If there's no active user's session, redirects to home servlet.
 * 
 * @author Grzegorz Kossowski
 * @version 1.0
 */
@WebServlet(
        name = "deletePersonServlet",
        urlPatterns = {"/deletePerson"}
)
public class DeletePersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        String personId = request.getParameter("id");
        JdbcUtil.deletePerson(personId);
        response.sendRedirect(request.getContextPath() + "/listPerson");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
