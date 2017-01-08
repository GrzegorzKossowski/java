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
        name = "doFindPersonServlet",
        urlPatterns = {"/doFindPerson"}
)
public class DoFindPersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //resolving polish diactric marks
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        List<Person> persons = null;

        String search = request.getParameter("search");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");

        if (search.equals("true")) {
            String sql = "SELECT * FROM person WHERE firstname='" + firstName + "' OR lastname='" + lastName + "' ORDER BY lastname, firstname";
            persons = JdbcUtil.getPersons(sql);
            session.setAttribute("menu", true);
            session.setAttribute("lastSearch", persons);
        } else if (search.equals("false")) {
            session.setAttribute("menu", false);
            session.setAttribute("lastSearch", null);
            System.out.println(">>>>>>>" + session.getAttribute("lastSearch"));
            response.sendRedirect(request.getContextPath() + "/listPerson");
            return;
        } else if (search.isEmpty() || search == null) {
            persons = (List<Person>) session.getAttribute("lastSearch");
        }

        request.setAttribute("persons", persons);
        request.getRequestDispatcher("/WEB-INF/jsp/view/list.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
