package com.tech.miaa.abdmApi;

import java.util.List;

public class AbdmSigungu {
    private HeaderResult headerResult;
    private List<AbdmSigunguItem> items;
    public AbdmSigungu() {

    }
    public AbdmSigungu(HeaderResult headerResult, List<AbdmSigunguItem> items) {
        this.headerResult = headerResult;
        this.items = items;
    }

    public HeaderResult getHeaderResult() {
        return headerResult;
    }

    public void setHeaderResult(HeaderResult headerResult) {
        this.headerResult = headerResult;
    }

    public List<AbdmSigunguItem> getItems() {
        return items;
    }

    public void setItems(List<AbdmSigunguItem> items) {
        this.items = items;
    }
}
