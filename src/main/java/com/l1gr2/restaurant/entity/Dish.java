package com.l1gr2.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @Column(name = "dish_id")
    private int Id;

    @Column(name = "dish_name")
    private String name;

    @Column(name = "descripion")
    private String descripion;

    @Column(name = "dish_price")
    private int price;

    @Column(name = "category")
    private String category;

    public Dish(int id, String name, String descripion, int price, String category) {
        Id = id;
        this.name = name;
        this.descripion = descripion;
        this.price = price;
        this.category = category;
    }

    public Dish(){

    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getDescripion() {
        return descripion;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name + "(" + descripion +")";
    }
}
