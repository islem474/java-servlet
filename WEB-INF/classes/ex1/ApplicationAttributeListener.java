package ex1;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationAttributeListener
        implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("[APPLICATION] Attribut ajouté");
        System.out.println("Nom : " + event.getName());
        System.out.println("Valeur : " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("[APPLICATION] Attribut remplacé");
        System.out.println("Nom : " + event.getName());
        System.out.println("Ancienne valeur : " + event.getValue());
        System.out.println("Nouvelle valeur : "
                + event.getServletContext().getAttribute(event.getName()));
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("[APPLICATION] Attribut supprimé");
        System.out.println("Nom : " + event.getName());
        System.out.println("Ancienne valeur : " + event.getValue());
    }
}