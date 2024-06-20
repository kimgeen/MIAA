package com.tech.miaa.abdmApi;

public enum KindEnum {
    ALL("","-전체-"),
    DOG("417000","개"),
    MALE("422400","고양이"),
    FEMALE("429900","기타");

    private String codeValue;
    private String value;
    KindEnum(String codeValue, String value) {
        this.codeValue = codeValue;
        this.value = value;
    }

    public String getCodeValue() {
        return codeValue;
    }

    public String getValue() {
        return value;
    }
}
