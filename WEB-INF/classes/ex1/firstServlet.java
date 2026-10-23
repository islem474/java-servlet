package ex1;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class firstServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException {

        // Get the information sent by the HTML form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDate = request.getParameter("birthDate");
        String sex = request.getParameter("sex");
        Cookie c1 = new Cookie("firstName", firstName);
        Cookie c2 = new Cookie("lastName", lastName);
        Cookie c3 = new Cookie("birthDay", birthDate);
        Cookie c4 = new Cookie("Sex", sex);
        // Ajouter les cookies a la reponse
        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        response.addCookie(c4);

        // Sets the response MIME type
        response.setContentType("text/html");

        // Gets a reference to a text-output stream
        PrintWriter out;
        out = response.getWriter();

        // Create the HTML page
        out.println("<HTML>");

        out.println("<HEAD>");
        out.println("<TITLE>Person Information</TITLE>");
        out.println("</HEAD>");

        out.println("<BODY>");

        out.println("<H1>Person Information</H1>");

        // Create the table
        out.println("<TABLE border='1'>");

        out.println("<TR>");
        out.println("<TH>First Name</TH>");
        out.println("<TH>Last Name</TH>");
        out.println("<TH>Birth Date</TH>");
        out.println("<TH>Sex</TH>");
        out.println("</TR>");

        out.println("<TR>");
        out.println("<TD>" + firstName + "</TD>");
        out.println("<TD>" + lastName + "</TD>");
        out.println("<TD>" + birthDate + "</TD>");
        out.println("<TD>" + sex + "</TD>");
        out.println("</TR>");

        out.println("</TABLE>");

        out.println("</BODY>");

        out.println("</HTML>");


        out.close();
    }
}