package controllers;

import models.Line;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class BackEndController {

    private static SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

    private ArrayList<Line> lines;

    public void loadLines() {

        Session session = null;

        try {
            session = factory.openSession();
            List<Line> result = session
                    .createQuery("FROM Line", Line.class)
                    .list();
            lines = new ArrayList<>(result);
        } catch (Exception e) {
            System.out.println("Erro ao carregar linhas: " + e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
    }

    public ArrayList<Line> getLines() {
        if (lines == null) {
            loadLines();
        }
        return lines;
    }
}