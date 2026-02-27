package models;

import java.util.Arrays;
import java.util.List;

public enum Line {

    CRONOS("Cronos", Arrays.asList(
            Category.CRONOS_OLD_MODELS,
            Category.CRONOS_L_MODELS,
            Category.CRONOS_NG_MODELS
    )),
    ARES("Ares", Arrays.asList(
            Category.ARES_TB_MODELS,
            Category.ARES_THS_MODELS
    ));

    private String name;
    private List<Category> categories;

    Line(String name, List<Category> categories){
        this.name = name;
        this.categories = categories;
    }

    public String getName(){
        return name;
    }

    public List<Category> getCategories(){
        return categories;
    }

    @Override
    public String toString() {
        return name;
    }
}