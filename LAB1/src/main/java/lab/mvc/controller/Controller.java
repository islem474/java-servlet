
package lab.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.mvc.model.Person;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String birthDay = request.getParameter("birthDay");
        String sex = request.getParameter("sex");

        Person person = new Person(
            firstName, lastName, birthDay, sex
        );

        request.setAttribute("person", person);

        int year = Integer.parseInt(birthDay.substring(6));

        String page;

        if (year < 1990) {
            page = "/old.jsp";
        } else {
            page = "/young.jsp";
        }

        RequestDispatcher dispatcher =
            request.getRequestDispatcher(page);

        dispatcher.forward(request, response);
    }
}
