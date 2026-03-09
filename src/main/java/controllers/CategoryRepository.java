package controllers;
import models.Category;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private ArrayList<Category> categories;

    public ArrayList<Category> loadCategories() {

        Session session = HibernateUtil.getFactory().openSession();

        List<Category> result = session
                .createQuery("FROM Line", Category.class)
                .list();
        categories = new ArrayList<>(result);
        session.close();
        return categories;
    }

}
