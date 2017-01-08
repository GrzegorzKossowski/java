/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        name = "doEditPersonServlet",
        urlPatterns = {"/doEditPerson"}
)
public class DoEditPersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //resolving polish diactric marks
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null || session.getAttribute("user").equals("")) {
            response.sendRedirect(request.getContextPath() + "/home");
            return;
        }

        String errorMsg = "";
        boolean isError = false;

        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String phone = request.getParameter("phone");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
            
        Person person = new Person(id, firstName, lastName, phone, mobile, email);

        if (StringUtils.isEmptyOrWhitespaceOnly(firstName) || StringUtils.isEmptyOrWhitespaceOnly(lastName)) {
            isError = true;
            errorMsg = "First name or last name can't be empty";
        }

        if (isError) {
            request.setAttribute("errorMsg", errorMsg);
            request.setAttribute("person", person);
            request.getRequestDispatcher("/WEB-INF/jsp/view/editPerson.jsp").forward(request, response);
        } else {
            JdbcUtil.updatePerson(person);
            response.sendRedirect(request.getContextPath() + "/listPerson");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}
