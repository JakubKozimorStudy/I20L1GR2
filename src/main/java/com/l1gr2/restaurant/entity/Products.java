package com.l1gr2.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produkty")
public class Products {

    @Id
    @Column(name = "Id")
    private int Id;

    @Column(name = "Nazwa")
    private String name;

    @Column(name = "Ilosc")
    private int quantity;

    @Column(name = "jednostka")
    private String unit;

    public Products(int id, String name, int quantity, String unit) {
        Id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public Products() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Products{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                '}';
    }
}
