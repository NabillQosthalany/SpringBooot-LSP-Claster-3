package com.latihanLsp.Model;

import java.util.Date;

public class LogPenjualan {
    private int id;
    private int stock_before;
    private int stock_after;
    private Date created_at;

    public LogPenjualan(Date created_at) {
        this.created_at = created_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public LogPenjualan(int id, int stock_before, int stock_after) {
        this.id = id;
        this.stock_before = stock_before;
        this.stock_after = stock_after;
    }

    public LogPenjualan() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock_before() {
        return stock_before;
    }

    public void setStock_before(int stock_before) {
        this.stock_before = stock_before;
    }

    public int getStock_after() {
        return stock_after;
    }

    public void setStock_after(int stock_after) {
        this.stock_after = stock_after;
    }
}
