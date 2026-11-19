package ex1;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {


        String username = request.getParameter("username");

        // 2. Creer ou recuperer la session
        HttpSession session = request.getSession();
        SessionUser user = new SessionUser(username);

        session.setAttribute("sessionUser", user);

        // 3. Enregistrer le username dans la session
        session.setAttribute("user", username);

        // 4. Afficher une confirmation
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Bienvenue " + username + " !</h2>");

        out.println("<p>Connexion reussie.</p>");

        out.println("<a href='items.html'>Acceder aux articles</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
