package com.l1gr2.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dania")
public class Dish {

    @Id
    @Column(name = "Id_dania")
    private int Id;

    @Column(name = "Nazwa")
    private String name;

    @Column(name = "Produkty")
    private String products;

    @Column(name = "Cena")
    private int price;

    public Dish(int id, String name, String products, int price) {
        Id = id;
        this.name = name;
        this.products = products;
        this.price = price;
    }

    public Dish(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /*@Override
    public String toString() {
        return "Dish{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", products='" + products + '\'' +
                ", price=" + price +
                '}';
    }*/

    @Override
    public String toString() {
        return  name + "(" + products + ")";
    }

}
