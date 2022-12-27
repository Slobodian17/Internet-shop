package com.peter.nulp.rozrahunkova.model.product;

import com.peter.nulp.rozrahunkova.model.Model;

public class Product implements Model {

    private long id;

    private String title;
    private String description;

    private long cost;

    public Product(){

    }

    public Product(String title, String description, long cost) {
        this.title = title;
        this.description = description;
        this.cost = cost;
    }

    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
