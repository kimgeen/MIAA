package com.tech.miaa.abdmApi;

import java.util.List;

public class AbdmSido {
    public final static String NUMOFROWS = "numOfRows";
    public final static String PAGENO = "pageNo";
    public final static String TOTALCOUNT = "totalCount";
    private HeaderResult headerResult;
    private List<AbdmSidoItem> items;
    //한 페이지 결과 수 
    private String numOfRows;
    //페이지 번호
    private String pageNo;
    //전체 결과 수
    private String totalCount;

    public AbdmSido() {

    }

    public AbdmSido(HeaderResult headerResult, List<AbdmSidoItem> items) {
        this.headerResult = headerResult;
        this.items = items;
    }

    public HeaderResult getHeaderResult() {
        return headerResult;
    }

    public void setHeaderResult(HeaderResult headerResult) {
        this.headerResult = headerResult;
    }

    public List<AbdmSidoItem> getItems() {
        return items;
    }

    public void setItems(List<AbdmSidoItem> items) {
        this.items = items;
    }

    public String getNumOfRows() {
        return numOfRows;
    }

    public void setNumOfRows(String numOfRows) {
        this.numOfRows = numOfRows;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
