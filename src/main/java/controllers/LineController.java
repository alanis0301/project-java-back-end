package controllers;
import models.Line;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class LineController {
    private ArrayList<Line> lines;

    public ArrayList<Line> loadLines() {

        Session session = BackEndController.getFactory().openSession();

        List<Line> result = session
                .createQuery("FROM Line", Line.class)
                .list();
        lines = new ArrayList<>(result);
        session.close();
        return lines;
    }

}
