package ex1;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class ActiveSessionListener implements HttpSessionListener {

    private static final AtomicInteger activeCount =
            new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent event) {

        int count = activeCount.incrementAndGet();

        ServletContext context =
                event.getSession().getServletContext();

        context.setAttribute("activeSessions", count);

        System.out.println("Nouvelle session créée");
        System.out.println("Sessions actives : " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {

        int count = activeCount.decrementAndGet();

        ServletContext context =
                event.getSession().getServletContext();

        context.setAttribute("activeSessions", count);

        System.out.println("Session détruite");
        System.out.println("Sessions actives : " + count);
    }
}
