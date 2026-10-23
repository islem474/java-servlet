
package ex1;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadCookie extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Recuperer les cookies
        Cookie[] cookies = request.getCookies();

        out.println("<html>");
        out.println("<head><title>Read Cookies</title></head>");
        out.println("<body>");
        out.println("<h1>Cookie Information</h1>");

        if (cookies != null) {
            out.println("<table border='1'>");
            out.println("<tr><th>Cookie Name</th><th>Cookie Value</th></tr>");

            for (Cookie c : cookies) {
                out.println("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getValue() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
        } else {
            out.println("<p>No cookies found.</p>");
        }

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {
        doGet(request, response);
    }
}
