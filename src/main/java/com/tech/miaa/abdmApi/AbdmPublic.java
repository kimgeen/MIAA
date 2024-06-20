package com.tech.miaa.abdmApi;

import java.util.List;

public class AbdmPublic {
    public final static String NUMOFROWS ="numOfRows";
    public final static String PAGENO ="pageNo";
    public final static String TOTALCOUNT ="totalCount";
    private HeaderResult headerResult;
    private List<AbdmPublicItem> items;
    //한 페이지 결과 수
    private String numOfRows;
    //페이지 번호
    private String pageNo;

    public String getNumOfRows() {
        return numOfRows;
    }

    //전체 결과 수

    private String totalCount;
    public AbdmPublic() {

    }

    public AbdmPublic(HeaderResult headerResult, List<AbdmPublicItem> items, String numOfRows, String pageNo, String totalCount) {
        this.headerResult = headerResult;
        this.items = items;
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
        this.totalCount = totalCount;
    }

    public HeaderResult getHeaderResult() {
        return headerResult;
    }

    public void setHeaderResult(HeaderResult headerResult) {
        this.headerResult = headerResult;
    }

    public List<AbdmPublicItem> getItems() {
        return items;
    }

    public void setItems(List<AbdmPublicItem> items) {
        this.items = items;
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
