package com.tech.miaa.abdmApi;

public class AbdmPublicItem {
    public final static String DESERTIONNO ="desertionNo";
    public final static String FILENAME ="filename";
    public final static String HAPPENDT ="happenDt";
    public final static String HAPPENPLACE ="happenPlace";
    public final static String KINDCD ="kindCd";
    public final static String COLORCD ="colorCd";
    public final static String AGE ="age";
    public final static String WEIGHT ="weight";
    public final static String NOTICENO ="noticeNo";
    public final static String NOTICESDT ="noticeSdt";
    public final static String NOTICEEDT ="noticeEdt";
    public final static String POPFILE ="popfile";
    public final static String PROCESSSTATE ="processState";
    public final static String SEXCD ="sexCd";
    public final static String NEUTERYN ="neuterYn";
    public final static String SPECIALMARK ="specialMark";
    public final static String CARENM ="careNm";
    public final static String CARETEL ="careTel";
    public final static String CAREADDR ="careAddr";
    public final static String ORGNM ="orgNm";
    public final static String CHARGENM ="chargeNm";
    public final static String OFFICETEL ="officetel";
    public final static String NOTICECOMMENT ="noticeComment";
    //유기번호
    private String desertionNo;
    //Thumbnail Image
    private String filename;
    //접수일
    private String happenDt;
    //발견장소
    private String happenPlace;
    //품종
    private String kindCd;
    //색상
    private String colorCd;
    //나이
    private String age;
    //체중
    private String weight;
    //공고번호
    private String noticeNo;
    //공고시작일
    private String noticeSdt;
    //공고종료일
    private String noticeEdt;
    //Image
    private String popfile;
    //상태
    private String processState;
    //성별
    private String sexCd;
    //중성화여부
    private String neuterYn;
    //특징
    private String specialMark;
    //보호소이름
    private String careNm;
    //보호소전화번호
    private String careTel;
    //보호장소
    private String careAddr;
    //관할기관
    private String orgNm;
    //담당자
    private String chargeNm;
    //담당자연락처
    private String officetel;
    //특이사항
    private String noticeComment;

    public AbdmPublicItem() {

    }

    public AbdmPublicItem(String desertionNo, String filename, String happenDt, String happenPlace, String kindCd, String colorCd, String age, String weight, String noticeNo, String noticeSdt, String noticeEdt, String popfile, String processState, String sexCd, String neuterYn, String specialMark, String careNm, String careTel, String careAddr, String orgNm, String chargeNm, String officetel, String noticeComment) {
        this.desertionNo = desertionNo;
        this.filename = filename;
        this.happenDt = happenDt;
        this.happenPlace = happenPlace;
        this.kindCd = kindCd;
        this.colorCd = colorCd;
        this.age = age;
        this.weight = weight;
        this.noticeNo = noticeNo;
        this.noticeSdt = noticeSdt;
        this.noticeEdt = noticeEdt;
        this.popfile = popfile;
        this.processState = processState;
        this.sexCd = sexCd;
        this.neuterYn = neuterYn;
        this.specialMark = specialMark;
        this.careNm = careNm;
        this.careTel = careTel;
        this.careAddr = careAddr;
        this.orgNm = orgNm;
        this.chargeNm = chargeNm;
        this.officetel = officetel;
        this.noticeComment = noticeComment;
    }

    public String getDesertionNo() {
        return desertionNo;
    }

    public void setDesertionNo(String desertionNo) {
        this.desertionNo = desertionNo;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getHappenDt() {
        return happenDt;
    }

    public void setHappenDt(String happenDt) {
        this.happenDt = happenDt;
    }

    public String getHappenPlace() {
        return happenPlace;
    }

    public void setHappenPlace(String happenPlace) {
        this.happenPlace = happenPlace;
    }

    public String getKindCd() {
        return kindCd;
    }

    public void setKindCd(String kindCd) {
        this.kindCd = kindCd;
    }

    public String getColorCd() {
        return colorCd;
    }

    public void setColorCd(String colorCd) {
        this.colorCd = colorCd;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNoticeNo() {
        return noticeNo;
    }

    public void setNoticeNo(String noticeNo) {
        this.noticeNo = noticeNo;
    }

    public String getNoticeSdt() {
        return noticeSdt;
    }

    public void setNoticeSdt(String noticeSdt) {
        this.noticeSdt = noticeSdt;
    }

    public String getNoticeEdt() {
        return noticeEdt;
    }

    public void setNoticeEdt(String noticeEdt) {
        this.noticeEdt = noticeEdt;
    }

    public String getPopfile() {
        return popfile;
    }

    public void setPopfile(String popfile) {
        this.popfile = popfile;
    }

    public String getProcessState() {
        return processState;
    }

    public void setProcessState(String processState) {
        this.processState = processState;
    }

    public String getSexCd() {
        return sexCd;
    }

    public void setSexCd(String sexCd) {
        this.sexCd = sexCd;
    }

    public String getNeuterYn() {
        return neuterYn;
    }

    public void setNeuterYn(String neuterYn) {
        this.neuterYn = neuterYn;
    }

    public String getSpecialMark() {
        return specialMark;
    }

    public void setSpecialMark(String specialMark) {
        this.specialMark = specialMark;
    }

    public String getCareNm() {
        return careNm;
    }

    public void setCareNm(String careNm) {
        this.careNm = careNm;
    }

    public String getCareTel() {
        return careTel;
    }

    public void setCareTel(String careTel) {
        this.careTel = careTel;
    }

    public String getCareAddr() {
        return careAddr;
    }

    public void setCareAddr(String careAddr) {
        this.careAddr = careAddr;
    }

    public String getOrgNm() {
        return orgNm;
    }

    public void setOrgNm(String orgNm) {
        this.orgNm = orgNm;
    }

    public String getChargeNm() {
        return chargeNm;
    }

    public void setChargeNm(String chargeNm) {
        this.chargeNm = chargeNm;
    }

    public String getOfficetel() {
        return officetel;
    }

    public void setOfficetel(String officetel) {
        this.officetel = officetel;
    }

    public String getNoticeComment() {
        return noticeComment;
    }

    public void setNoticeComment(String noticeComment) {
        this.noticeComment = noticeComment;
    }
}
