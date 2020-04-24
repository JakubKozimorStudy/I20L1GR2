package com.l1gr2.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "pracownicy")
public class Users {

    @Id
    @Column(name = "login")
    private String login;
    @Column(name = "Imie")
    private String firstName;
    @Column(name = "Nazwisko")
    private String lastName;
    @Column(name = "haslo")
    private String password;
    @Column(name = "rola")
    private String role;

    public Users() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "Users{" +
                "login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
