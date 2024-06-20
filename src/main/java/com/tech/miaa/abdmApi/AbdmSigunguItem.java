package com.tech.miaa.abdmApi;

public class AbdmSigunguItem {
    public final static String ORGCD ="orgCd";
    public final static String ORGDOWNNM ="orgdownNm";
    public final static String UPRCD ="uprCd";
    //시군구상위코드
    private String uprCd;
    //시군구코드
    private String orgCd;
    //시군구명
    private String orgdownNm;

    public AbdmSigunguItem() {

    }

    public AbdmSigunguItem(String uprCd, String orgCd, String orgdownNm) {
        this.uprCd = uprCd;
        this.orgCd = orgCd;
        this.orgdownNm = orgdownNm;
    }

    public String getOrgCd() {
        return orgCd;
    }

    public void setOrgCd(String orgCd) {
        this.orgCd = orgCd;
    }

    public String getOrgdownNm() {
        return orgdownNm;
    }

    public void setOrgdownNm(String orgdownNm) {
        this.orgdownNm = orgdownNm;
    }

    public String getUprCd() {
        return uprCd;
    }

    public void setUprCd(String uprCd) {
        this.uprCd = uprCd;
    }
}
