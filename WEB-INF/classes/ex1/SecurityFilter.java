package ex1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {

        System.out.println("SecurityFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        HttpServletResponse httpResponse =
                (HttpServletResponse) response;

        // 1. Recuperer la session existante
        HttpSession session = httpRequest.getSession(false);

        // 2. Verifier si l'utilisateur est connecte
        if (session != null && session.getAttribute("user") != null) {

            System.out.println("Utilisateur autorise");

            // 3. Autoriser l'acces a ListItems
            chain.doFilter(request, response);

        } else {

            System.out.println("Utilisateur non autorise");

            // 4. Rediriger vers login.html
            httpResponse.sendRedirect(
                httpRequest.getContextPath() + "/login.html"
            );
        }
    }

    @Override
    public void destroy() {

        System.out.println("SecurityFilter destroyed");
    }
}
