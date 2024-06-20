package com.tech.miaa.abdmApi;

public enum SexEnum {
    ALL("","-전체-"),
    MALE("M","수컷"),
    FEMALE("F","암컷"),
    U("U","미상");

    private String codeValue;
    private String value;
    SexEnum(String codeValue, String value) {
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
