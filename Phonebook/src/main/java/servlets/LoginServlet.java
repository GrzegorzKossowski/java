package servlets;

import beans.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.JdbcUtil;

/**
 * Authenticate users. Stores user in session variable. 
 *
 * @author Grzegorz Kossowski
 * @version 1.0
 */
@WebServlet(
        name = "loginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //resolving polish diactric marks
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        
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
            errorMsg += "<br/>Invalid user or password";
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

        } else {
            
            session.setAttribute("user", user.getLogin());
            // stores information about additional menu (for authenticated users only)
            session.setAttribute("menu", false);
            // stores information about last search executed (for additional menu only)
            session.setAttribute("lastSearch", null);
            response.sendRedirect(request.getContextPath() + "/listPerson");
            
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
