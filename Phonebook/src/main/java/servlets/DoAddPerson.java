package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author grze
 */
@WebServlet(
        name = "doAddPerson",
        urlPatterns = "/doAddPerson"
)
public class DoAddPerson extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean dbError = true;
        
        if(dbError) {
            request.getRequestDispatcher("/WEB-INF/jsp/view/errorAddPerson.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/jsp/view/confirmAddPerson.jsp").forward(request, response);            
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    
    
    
}
