package ex1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

@WebServlet("/TestAttributeListeners")
public class TestAttributeListeners extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        ServletContext context = getServletContext();

        // TEST APPLICATION : ajout
        context.setAttribute("testApplication", "Valeur 1");

        // TEST APPLICATION : remplacement
        context.setAttribute("testApplication", "Valeur 2");

        // TEST APPLICATION : suppression
        context.removeAttribute("testApplication");


        // TEST REQUEST : ajout
        request.setAttribute("testRequest", "Valeur 1");

        // TEST REQUEST : remplacement
        request.setAttribute("testRequest", "Valeur 2");

        // TEST REQUEST : suppression
        request.removeAttribute("testRequest");

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("Test des deux Listeners terminé !");
    }
}