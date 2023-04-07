package com.latihanLsp.Model;


import javax.xml.crypto.Data;
import java.util.Date;

public class ProductWithCategory implements Data {

   private int price;
   private int amount_sold;
   private int stock;
   private Date tgl_input;
   private String name_category;
   private String description;

    public ProductWithCategory(int price, int amount_sold, int stock, Date tgl_input, String name_category, String description) {
        this.price = price;
        this.amount_sold = amount_sold;
        this.stock = stock;
        this.tgl_input = tgl_input;
        this.name_category = name_category;
        this.description = description;
    }

    public ProductWithCategory() {

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

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
