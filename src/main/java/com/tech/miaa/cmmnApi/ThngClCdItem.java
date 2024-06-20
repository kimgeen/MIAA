package com.tech.miaa.cmmnApi;

public class ThngClCdItem {
    public final static String PRDTCD ="prdtCd";
    public final static String PRDTNM ="prdtNm";
    public final static String HIPRDTCD ="hiPrdtCd";
    //물품분류코드
    private String prdtCd;
    //물품분류명
    private String prdtNm;
    //상위물품코드
    private String hiPrdtCd;

    public ThngClCdItem() {

    }

    public ThngClCdItem(String prdtCd, String prdtNm, String hiPrdtCd) {
        this.prdtCd = prdtCd;
        this.prdtNm = prdtNm;
        this.hiPrdtCd = hiPrdtCd;
    }

    public String getPrdtCd() {
        return prdtCd;
    }

    public void setPrdtCd(String prdtCd) {
        this.prdtCd = prdtCd;
    }

    public String getPrdtNm() {
        return prdtNm;
    }

    public void setPrdtNm(String prdtNm) {
        this.prdtNm = prdtNm;
    }

    public String getHiPrdtCd() {
        return hiPrdtCd;
    }

    public void setHiPrdtCd(String hiPrdtCd) {
        this.hiPrdtCd = hiPrdtCd;
    }
}
