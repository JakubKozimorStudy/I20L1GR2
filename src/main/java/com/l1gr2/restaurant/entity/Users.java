package com.l1gr2.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "name")
    private String fullname;
    @Column(name = "password")
    private String password;
    @Column(name = "position")
    private  String role;

    public Users(String login, String fullname, String password, String role) {
        this.login = login;
        this.fullname = fullname;
        this.password = password;
        this.role = role;
    }
    public Users (){};

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
