package servlets;

import beans.Person;
import com.mysql.jdbc.StringUtils;
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

        //resolving polish diactric marks
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        boolean dbError = true;
        String errorMsg = "";
        boolean isError = false;

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");

        if (StringUtils.isEmptyOrWhitespaceOnly(firstName) || StringUtils.isEmptyOrWhitespaceOnly(lastName)) {
            isError = true;
            errorMsg = "First name or Last can't be empty";
        }

        if (isError) {
            request.setAttribute("errorMsg", errorMsg);
            request.getRequestDispatcher("/WEB-INF/jsp/view/addPerson.jsp").forward(request, response);
        } else {
            
            Person person = new Person(firstName, lastName, phone, mobile, email);
            dbError = JdbcUtil.savePerson(person);

            if (dbError) {
                request.getRequestDispatcher("/WEB-INF/jsp/view/errorAddPerson.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/jsp/view/confirmAddPerson.jsp").forward(request, response);
            }
            
        }
        

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
