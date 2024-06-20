package com.tech.miaa.cmmnApi;

import com.tech.miaa.abdmApi.HeaderResult;

import java.util.List;

public class ThngClCd {
    //헤더 결과코드
    private HeaderResult headerResult;
    //결과 데이터
    private List<ThngClCdItem> items;

    public ThngClCd() {
        
    }
    public ThngClCd(HeaderResult headerResult, List<ThngClCdItem> items) {
        this.headerResult = headerResult;
        this.items = items;
    }

    public HeaderResult getHeaderResult() {
        return headerResult;
    }

    public void setHeaderResult(HeaderResult headerResult) {
        this.headerResult = headerResult;
    }

    public List<ThngClCdItem> getItems() {
        return items;
    }

    public void setItems(List<ThngClCdItem> items) {
        this.items = items;
    }
}
