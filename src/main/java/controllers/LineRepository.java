package controllers;
import models.Line;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class LineRepository {
    private ArrayList<Line> lines;

    public ArrayList<Line> loadLines() {

        Session session = HibernateUtil.getFactory().openSession();

        List<Line> result = session
                .createQuery("FROM Line", Line.class)
                .list();
        lines = new ArrayList<>(result);
        session.close();
        return lines;
    }

}
