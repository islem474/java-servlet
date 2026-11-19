package ex1;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowSession extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        // Récupérer le nombre de sessions actives
        Integer activeSessions = (Integer)
                getServletContext().getAttribute("activeSessions");

        if (activeSessions == null) {
            activeSessions = 0;
        }

        String fullName = (String) session.getAttribute("fullName");
        String birthDate = (String) session.getAttribute("birthDate");

        out.println("<html><body>");

        // Afficher le nombre de sessions actives
        out.println("<h2>Nombre de sessions actives : "
                + activeSessions + "</h2>");

        if (fullName == null || birthDate == null) {

            out.println("<h1>Welcome!</h1>");
            out.println("<p>Please enter your information:</p>");

            out.println("<form action='ShowSession' method='post'>");

            out.println("Full Name: ");
            out.println("<input type='text' name='fullName' required>");
            out.println("<br><br>");

            out.println("Date of Birth: ");
            out.println("<input type='date' name='birthDate' required>");
            out.println("<br><br>");

            out.println("<input type='submit' value='Submit'>");

            out.println("</form>");

        } else {

            LocalDate birthday = LocalDate.parse(birthDate);
            LocalDate today = LocalDate.now();

            LocalDate nextBirthday = birthday.withYear(today.getYear());

            if (!nextBirthday.isAfter(today)) {
                nextBirthday = nextBirthday.plusYears(1);
            }

            long days = ChronoUnit.DAYS.between(today, nextBirthday);

            out.println("<h1>Hi, " + fullName + ".</h1>");
            out.println("<p>There are " + days
                        + " days to your birthday.</p>");
        }

        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws IOException {

        request.setCharacterEncoding("UTF-8");

        String fullName = request.getParameter("fullName");
        String birthDate = request.getParameter("birthDate");

        HttpSession session = request.getSession();

        session.setAttribute("fullName", fullName);
        session.setAttribute("birthDate", birthDate);

        response.sendRedirect("ShowSession");
    }
}
