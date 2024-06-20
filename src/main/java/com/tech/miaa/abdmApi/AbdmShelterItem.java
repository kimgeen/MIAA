package com.tech.miaa.abdmApi;

public class AbdmShelterItem {
    public final static String CAREREGNO ="careRegNo";
    public final static String CARENM ="careNm";
    //보호소번호
    private String careRegNo;
    //보호소명
    private String careNm;
    public AbdmShelterItem() {

    }
    public AbdmShelterItem(String careRegNo, String careNm) {
        this.careRegNo = careRegNo;
        this.careNm = careNm;
    }

    public String getCareRegNo() {
        return careRegNo;
    }

    public void setCareRegNo(String careRegNo) {
        this.careRegNo = careRegNo;
    }

    public String getCareNm() {
        return careNm;
    }

    public void setCareNm(String careNm) {
        this.careNm = careNm;
    }
}
