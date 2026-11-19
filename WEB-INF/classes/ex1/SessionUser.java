package ex1;

import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionUser implements HttpSessionBindingListener {

    private String username;

    public SessionUser(String username) {
        this.username = username;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("SessionUser ajouté à la session !");
        System.out.println("Nom : " + username);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("SessionUser retiré de la session !");
        System.out.println("Nom : " + username);
    }
}
