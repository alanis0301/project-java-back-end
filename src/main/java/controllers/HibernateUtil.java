package controllers;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    @Getter
    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().buildSessionFactory();
    }
}