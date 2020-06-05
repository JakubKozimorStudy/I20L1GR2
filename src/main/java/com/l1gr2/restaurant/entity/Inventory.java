package com.l1gr2.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @Column(name = "product_Id")
    private int product_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_quantity")
    private int product_quantity;

    @Column(name = "product_price")
    private int product_price;



    public Inventory(){}

    public Inventory(int product_id, String product_name, int product_quantity, int product_price) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_quantity = product_quantity;
        this.product_price = product_price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_quantity=" + product_quantity +
                ", product_price=" + product_price +
                '}';
    }
}
