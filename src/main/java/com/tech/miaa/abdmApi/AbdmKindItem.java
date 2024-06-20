package com.tech.miaa.abdmApi;

public class AbdmKindItem {
    public final static String KINDCD ="kindCd";
    public final static String KNM ="KNm";
    //품종코드
    private String kindCd;
    //품종명
    private String KNm;
    public AbdmKindItem() {

    }
    public AbdmKindItem(String kindCd, String KNm) {
        this.kindCd = kindCd;
        this.KNm = KNm;
    }

    public String getKindCd() {
        return kindCd;
    }

    public void setKindCd(String kindCd) {
        this.kindCd = kindCd;
    }

    public String getKNm() {
        return KNm;
    }

    public void setKNm(String KNm) {
        this.KNm = KNm;
    }
}
