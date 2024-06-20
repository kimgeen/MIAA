package com.tech.miaa.abdmApi;

import java.util.List;

public class AbdmShelter {
    private HeaderResult headerResult;
    private List<AbdmShelterItem> items;
    public AbdmShelter() {

    }
    public AbdmShelter(HeaderResult headerResult, List<AbdmShelterItem> items) {
        this.headerResult = headerResult;
        this.items = items;
    }

    public HeaderResult getHeaderResult() {
        return headerResult;
    }

    public void setHeaderResult(HeaderResult headerResult) {
        this.headerResult = headerResult;
    }

    public List<AbdmShelterItem> getItems() {
        return items;
    }

    public void setItems(List<AbdmShelterItem> items) {
        this.items = items;
    }
}
