
package ex1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class VisitCookie extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException {

        // Type de la reponse
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Initialiser le compteur
        int visits = 0;

        // Recuperer les cookies envoyes par le navigateur
        Cookie[] cookies = request.getCookies();

        // Verifier si des cookies existent
        if (cookies != null) {

            // Parcourir tous les cookies
            for (Cookie c : cookies) {

                // Chercher le cookie visits
                if (c.getName().equals("visits")) {

                    // Recuperer sa valeur et la convertir en entier
                    visits = Integer.parseInt(c.getValue());
                }
            }
        }

        // Incrementer le nombre de visites
        visits++;

        // Creer le cookie avec la nouvelle valeur
        Cookie visitCookie =
                new Cookie("visits", String.valueOf(visits));

        // Duree de vie du cookie : 30 jours
        visitCookie.setMaxAge(60 * 60 * 24 * 30);

        // Envoyer le cookie au navigateur
        response.addCookie(visitCookie);

        // Afficher le resultat dans le navigateur
        out.println("<html>");
        out.println("<head><title>Visit Counter</title></head>");
        out.println("<body>");

        out.println("<h1>Visit Counter</h1>");
        out.println("<p>Number of visits: " + visits + "</p>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    // Si une requete POST arrive, appeler doGet
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {

        doGet(request, response);
    }
}
