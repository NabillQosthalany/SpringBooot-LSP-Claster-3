package com.latihanLsp.Model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Product {
    @ApiModelProperty(position = 1)
    private int id;
    @ApiModelProperty(position = 2)
    private int price;
    @ApiModelProperty(position = 3)
    private int amount_sold;
    @ApiModelProperty(position = 4)
    private int category_id;
    @ApiModelProperty(position = 4)
    private int stock;
    @ApiModelProperty(position = 5)
    private Date tgl_input;

    public Product(int id, int price, int amount_sold, int category_id, int stock, Date tgl_input) {
        this.id = id;
        this.price = price;
        this.amount_sold = amount_sold;
        this.category_id = category_id;
        this.stock = stock;
        this.tgl_input = tgl_input;
    }

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount_sold() {
        return amount_sold;
    }

    public void setAmount_sold(int amount_sold) {
        this.amount_sold = amount_sold;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getTgl_input() {
        return tgl_input;
    }

    public void setTgl_input(Date tgl_input) {
        this.tgl_input = tgl_input;
    }
}





