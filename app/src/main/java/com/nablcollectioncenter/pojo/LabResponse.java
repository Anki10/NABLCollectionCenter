package com.nablcollectioncenter.pojo;

import java.util.ArrayList;

/**
 * Created by raj on 3/19/2018.
 */

public class LabResponse {

    private String total;
    private String rowCount;
    private String current;

    public ArrayList<LabRowResponse> getRows() {
        return rows;
    }

    public void setRows(ArrayList<LabRowResponse> rows) {
        this.rows = rows;
    }

    private ArrayList<LabRowResponse> rows;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getRowCount() {
        return rowCount;
    }

    public void setRowCount(String rowCount) {
        this.rowCount = rowCount;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }





}
