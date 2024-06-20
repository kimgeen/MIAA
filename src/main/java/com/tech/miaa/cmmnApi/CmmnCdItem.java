package com.tech.miaa.cmmnApi;

public class CmmnCdItem {
    public final static String COMMCD ="commCd";
    public final static String CDNM ="cdNm";
    public final static String COMMGRPCD ="commGrpCd";
    public final static String GRPNM ="grpNm";
    //공통코드
    private String commCd;
    //공통코드명
    private String cdNm;
    //공통그룹코드
    private String commGrpCd;
    //그룹명
    private String grpNm;
    public CmmnCdItem() {

    }
    public CmmnCdItem(String commCd, String cdNm, String commGrpCd, String grpNm) {
        this.commCd = commCd;
        this.cdNm = cdNm;
        this.commGrpCd = commGrpCd;
        this.grpNm = grpNm;
    }

    public String getCommCd() {
        return commCd;
    }

    public void setCommCd(String commCd) {
        this.commCd = commCd;
    }

    public String getCdNm() {
        return cdNm;
    }

    public void setCdNm(String cdNm) {
        this.cdNm = cdNm;
    }

    public String getCommGrpCd() {
        return commGrpCd;
    }

    public void setCommGrpCd(String commGrpCd) {
        this.commGrpCd = commGrpCd;
    }

    public String getGrpNm() {
        return grpNm;
    }

    public void setGrpNm(String grpNm) {
        this.grpNm = grpNm;
    }
}
