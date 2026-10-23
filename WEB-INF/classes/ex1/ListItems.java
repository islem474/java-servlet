package ex1;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;

public class ListItems extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                      throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        ArrayList<String> items =
            (ArrayList<String>) session.getAttribute("items");

        if (items == null) {
            items = new ArrayList<String>();
            session.setAttribute("items", items);
        }

        out.println("<html><body>");

        out.println("<h1>Add an item</h1>");

        out.println("<form action='ListItems' method='post'>");
        out.println("<input type='text' name='item' required>");
        out.println("<input type='submit' value='Add'>");
        out.println("</form>");

        out.println("<h2>List of items</h2>");

        if (items.isEmpty()) {
            out.println("<p>The list is empty.</p>");
        } else {
            out.println("<ul>");

            for (String item : items) {

                int count = 0;

                for (String i : items) {
                    if (i.equalsIgnoreCase(item)) {
                        count++;
                    }
                }

                if (items.indexOf(item) == items.lastIndexOf(item)) {
                    out.println("<li>" + item + " : "
                                + count + " fois</li>");
                }
            }

            out.println("</ul>");
        }

        out.println("</body></html>");
        out.close();
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
                       throws IOException {

        request.setCharacterEncoding("UTF-8");

        String item = request.getParameter("item");

        HttpSession session = request.getSession();

        ArrayList<String> items =
            (ArrayList<String>) session.getAttribute("items");

        if (items == null) {
            items = new ArrayList<String>();
            session.setAttribute("items", items);
        }

        if (item != null && !item.trim().isEmpty()) {
            items.add(item.trim());
        }

        response.sendRedirect("ListItems");
    }
}
