
package ex1;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {

    private String logPrefix;

    @Override
    public void init(FilterConfig filterConfig)
            throws ServletException {

        logPrefix = filterConfig.getInitParameter("logPrefix");

        System.out.println(logPrefix + " LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest =
                (HttpServletRequest) request;

        System.out.println(logPrefix + " Request URL: "
                + httpRequest.getRequestURL());

        chain.doFilter(request, response);

        System.out.println(logPrefix + " Request processing completed");
    }

    @Override
    public void destroy() {
        System.out.println(logPrefix + " LoggingFilter destroyed");
    }
}
