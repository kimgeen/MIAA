package com.tech.miaa.abdmApi;

import java.util.List;

public class AbdmKind {
    private HeaderResult headerResult;
    private List<AbdmKindItem> items;
    public AbdmKind() {

    }
    public AbdmKind(HeaderResult headerResult, List<AbdmKindItem> items) {
        this.headerResult = headerResult;
        this.items = items;
    }

    public HeaderResult getHeaderResult() {
        return headerResult;
    }

    public void setHeaderResult(HeaderResult headerResult) {
        this.headerResult = headerResult;
    }

    public List<AbdmKindItem> getItems() {
        return items;
    }

    public void setItems(List<AbdmKindItem> items) {
        this.items = items;
    }
}
