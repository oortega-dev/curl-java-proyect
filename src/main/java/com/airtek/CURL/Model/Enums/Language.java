package com.airtek.CURL.Model.Enums;

public enum Language {
    ENGLISH("ENG");


    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private Language(String code) {
        this.code = code;
    }

    public static Language getLanguage(String code) {
        if (null != code) {
            switch (code) {
                case "ENG":
                    return Language.ENGLISH;
                default:
                    return Language.ENGLISH;

            }
        }
        return null;
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
