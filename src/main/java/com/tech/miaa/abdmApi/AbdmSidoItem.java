package com.tech.miaa.abdmApi;

public class AbdmSidoItem {
    public final static String ORGCD ="orgCd";
    public final static String ORGDOWNNM ="orgdownNm";
    //시도코드
    private String orgCd;
    //시도명
    private String orgdownNm;

    public AbdmSidoItem() {
    }

    public AbdmSidoItem(String orgCd, String orgdownNm) {
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
}
