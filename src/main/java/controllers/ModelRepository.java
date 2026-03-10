package controllers;
import models.Model;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class ModelRepository {
    private ArrayList<Model> models;

    public ArrayList<Model> loadModels() {

        Session session = HibernateUtil.getFactory().openSession();

        List<Model> result = session
                .createQuery("FROM Line", Model.class)
                .list();
        models = new ArrayList<>(result);
        session.close();
        return models;
    }

}
