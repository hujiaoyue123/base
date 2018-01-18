package com.boxin.base.managemodel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 针对easyui表格中需要total,rows情况
 * Created by zy on 2015/5/6.
 */
public class GridData {

    private int total = 0; //数据总条数
    private List rows = new ArrayList();    //数据内容

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
