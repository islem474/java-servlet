package ex1;

import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestAttributeListener
        implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("[REQUEST] Attribut ajouté");
        System.out.println("Nom : " + event.getName());
        System.out.println("Valeur : " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println("[REQUEST] Attribut remplacé");
        System.out.println("Nom : " + event.getName());
        System.out.println("Ancienne valeur : " + event.getValue());
        System.out.println("Nouvelle valeur : "
                + event.getServletRequest().getAttribute(event.getName()));
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("[REQUEST] Attribut supprimé");
        System.out.println("Nom : " + event.getName());
        System.out.println("Ancienne valeur : " + event.getValue());
    }
}