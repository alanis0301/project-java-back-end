package models;

import java.util.Arrays;
import java.util.List;

public enum Category {

    CRONOS_OLD_MODELS("Cronos Old", Arrays.asList(
            Model.CRONOS_OLD_6001A,
            Model.CRONOS_OLD_6003,
            Model.CRONOS_OLD_7023
    )),
    CRONOS_L_MODELS("Cronos L", Arrays.asList(
            Model.CRONOS_L_6021,
            Model.CRONOS_L_7023
    )),
    CRONOS_NG_MODELS("Cronos NG", Arrays.asList(
            Model.CRONOS_NG_6001,
            Model.CRONOS_NG_6003,
            Model.CRONOS_NG_6021,
            Model.CRONOS_NG_6031,
            Model.CRONOS_NG_7021,
            Model.CRONOS_NG_7023
    )),
    ARES_TB_MODELS("Ares TB", Arrays.asList(
            Model.ARES_TB_7021,
            Model.ARES_TB_7031,
            Model.ARES_TB_7023
    )),
    ARES_THS_MODELS("Ares THS", Arrays.asList(
            Model.ARES_THS_8023_15,
            Model.ARES_THS_8023_200,
            Model.ARES_THS_8023_25
    ));

    private final String name;
    private final List<Model> models;

    Category(String name, List<Model> models){
        this.name = name;
        this.models = models;
    }

    public String getName(){
        return name;
    }

    public List<Model> getModels(){
        return models;
    }

    @Override
    public String toString() {
        return name;
    }
}