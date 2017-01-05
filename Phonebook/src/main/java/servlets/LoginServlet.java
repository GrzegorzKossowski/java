package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String userPasswq = request.getParameter("password");

        if (userLogin == null || userLogin.isEmpty()) {
//        if (request.getParameter("login").equals("mickey")) {
            isError = true;
            errorMsg += "Login empty... ";            
        }
        
        if (userPasswq == null || userPasswq.isEmpty()) {
//        if (request.getParameter("login").equals("mickey")) {
            isError = true;
            errorMsg += "Password empty... ";            
        }
        
        if(isError) {
            request.setAttribute("errorMsg", errorMsg);
            if(!userPasswq.isEmpty()) {
                request.setAttribute("login", userPasswq);
            }
            if(!userLogin.isEmpty()) {
                request.setAttribute("login", userLogin);
            }
            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);            
        }

//        HttpSession session = request.getSession(true);
//        String attr = request.getParameter("login");
//        session.setAttribute("attr", attr);
//        System.out.println(session.getAttribute("attr"));

        response.sendRedirect(request.getContextPath() + "/list");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
