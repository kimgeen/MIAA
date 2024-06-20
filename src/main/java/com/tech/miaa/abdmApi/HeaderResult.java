package com.tech.miaa.abdmApi;

public class HeaderResult {
    public final static String REQNO = "reqNo";
    public final static String RESULTCODE = "resultCode";
    public final static String RESULTMAG = "resultMsg";
    //결과코드
    private String resultCode;
    //결과메시지
    private String resultMsg;
    //요청번호
    private String reqNo;

    public HeaderResult(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public HeaderResult() {

    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }
}
