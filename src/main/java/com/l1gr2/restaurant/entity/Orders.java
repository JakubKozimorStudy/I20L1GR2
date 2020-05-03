package com.l1gr2.restaurant.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "summary")
public class Orders {

    @Id
    @Column(name = "summary_Id")
    private int Id;

    @Column(name = "Date")
    private Date date;

    @Column(name = "status")
    private String status;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name="dish")
    private Dish dish;


    public Orders(int id, Date date, Dish dish, String status) {
        Id = id;
        this.date = date;
        this.dish = dish;
        this.status = status;
    }

    public Orders()
    {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "Id=" + Id +
                ", date='" + date + '\'' +
                ", dish=" + dish +
                ", status='" + status + '\'' +
                '}';
    }
}
