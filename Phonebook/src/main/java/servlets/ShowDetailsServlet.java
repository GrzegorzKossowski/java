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

        Person person = JdbcUtil.getPerson(request.getParameter("id"));
        request.setAttribute("person", person);
        request.getRequestDispatcher("/WEB-INF/jsp/view/showDetails.jsp").forward(request, response);
        
    }

}