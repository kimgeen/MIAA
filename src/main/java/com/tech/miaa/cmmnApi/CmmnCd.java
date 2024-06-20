package com.tech.miaa.cmmnApi;

import com.tech.miaa.abdmApi.HeaderResult;

import java.util.List;

public class CmmnCd {
    //헤더 결과코드
    private HeaderResult headerResult;
    //결과 데이터
    private List<CmmnCdItem> items;

    public CmmnCd() {

    }
    public CmmnCd(HeaderResult headerResult, List<CmmnCdItem> items) {
        this.headerResult = headerResult;
        this.items = items;
    }

    public HeaderResult getHeaderResult() {
        return headerResult;
    }

    public void setHeaderResult(HeaderResult headerResult) {
        this.headerResult = headerResult;
    }

    public List<CmmnCdItem> getItems() {
        return items;
    }

    public void setItems(List<CmmnCdItem> items) {
        this.items = items;
    }
}
