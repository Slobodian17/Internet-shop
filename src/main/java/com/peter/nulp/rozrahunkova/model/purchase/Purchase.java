package com.peter.nulp.rozrahunkova.model.purchase;

import com.peter.nulp.rozrahunkova.model.Model;

public class Purchase implements Model {

    private long id;

    private long user_id;
    private long product_id;
    private long money;


    public Purchase(long user_id, long product_id, long money) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.money = money;
    }

    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}
