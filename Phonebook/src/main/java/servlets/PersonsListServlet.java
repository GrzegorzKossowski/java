package servlets;

import beans.Person;
import java.io.IOException;
import java.util.List;
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
        
        List<Person> persons = JdbcUtil.getPersons();

        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/WEB-INF/jsp/view/list.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}