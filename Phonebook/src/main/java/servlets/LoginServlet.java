package servlets;

import beans.User;
import hibernate.HibernateUtil;
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
        name = "proceedLoginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String errorMsg = "";
        boolean isError = false;
        String userLogin = request.getParameter("login");
        String userPasswd = request.getParameter("password");
        User user = new User(userLogin, userPasswd);

        if (userLogin == null || userLogin.isEmpty()) {
            isError = true;
            errorMsg += "Login empty... ";
        }

        if (userPasswd == null || userPasswd.isEmpty()) {
            isError = true;
            errorMsg += "Password empty... ";
        }

        if (!JdbcUtil.isUserValid(user)) {
            isError = true;
            errorMsg += "Invalid user or password";
        }

        if (isError) {
            
            request.setAttribute("errorMsg", errorMsg);
            if (!userLogin.isEmpty()) {
                request.setAttribute("login", userLogin);
            }
            if (!userPasswd.isEmpty()) {
                request.setAttribute("password", userPasswd);
            }
            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
            
        }

        HttpSession session = request.getSession();
        session.setAttribute("user", user.getLogin());

        response.sendRedirect(request.getContextPath() + "/listPerson");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
