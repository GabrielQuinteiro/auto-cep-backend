package com.example.AutoCEP.entity.common.enums;

public enum DDD {
    SP_11("11"),
    SP_12("12"),
    SP_13("13"),
    SP_14("14"),
    SP_15("15"),
    SP_16("16"),
    SP_17("17"),
    SP_18("18"),
    SP_19("19"),

    RJ_21("21"),
    RJ_22("22"),
    RJ_24("24"),

    ES_27("27"),
    ES_28("28"),

    MG_31("31"),
    MG_32("32"),
    MG_33("33"),
    MG_34("34"),
    MG_35("35"),
    MG_37("37"),
    MG_38("38"),

    PR_41("41"),
    PR_42("42"),
    PR_43("43"),
    PR_44("44"),
    PR_45("45"),
    PR_46("46"),

    SC_47("47"),
    SC_48("48"),
    SC_49("49"),

    RS_51("51"),
    RS_53("53"),
    RS_54("54"),
    RS_55("55"),

    DF_GO_61("61"),
    GO_62("62"),
    TO_63("63"),
    GO_64("64"),

    MT_65("65"),
    MT_66("66"),
    MS_67("67"),

    AC_68("68"),
    RO_69("69"),

    BA_71("71"),
    BA_73("73"),
    BA_74("74"),
    BA_75("75"),
    BA_77("77"),

    SE_79("79"),

    PE_81("81"),
    AL_82("82"),
    PB_83("83"),
    RN_84("84"),
    CE_85("85"),
    PI_86("86"),
    PE_87("87"),
    CE_88("88"),
    PI_89("89"),

    PA_91("91"),
    AM_92("92"),
    PA_93("93"),
    PA_94("94"),
    RR_95("95"),
    AP_96("96"),
    AM_97("97"),

    MA_98("98"),
    MA_99("99");

    private final String ddd;

    DDD(String ddd) {
        this.ddd = ddd;
    }

    public static boolean isValid(String ddd) {
        for (DDD d : DDD.values()) {
            if (d.getDdd().equals(ddd)) {
                return true;
            }
        }
        return false;
    }

    public String getDdd() {
        return ddd;
    }
}
