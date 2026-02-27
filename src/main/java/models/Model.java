package models;

public enum Model {

    CRONOS_OLD_6001A("Cronos 6001-A"),
    CRONOS_OLD_6003("Cronos 6003"),
    CRONOS_OLD_7023("Cronos 7023"),

    CRONOS_L_6021("Cronos 6021L"),
    CRONOS_L_7023("Cronos 7023L"),

    CRONOS_NG_6001("Cronos 6001-NG"),
    CRONOS_NG_6003("Cronos 6003-NG"),
    CRONOS_NG_6021("Cronos 6021-NG"),
    CRONOS_NG_6031("Cronos 6031-NG"),
    CRONOS_NG_7021("Cronos 7021-NG"),
    CRONOS_NG_7023("Cronos 7023-NG"),

    ARES_TB_7021("Ares 7021"),
    ARES_TB_7031("Ares 7031"),
    ARES_TB_7023("Ares 7023"),

    ARES_THS_8023_15("Ares 8023 15"),
    ARES_THS_8023_200("Ares 8023 200"),
    ARES_THS_8023_25("Ares 8023 2,5");

    private String name;

    Model(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}