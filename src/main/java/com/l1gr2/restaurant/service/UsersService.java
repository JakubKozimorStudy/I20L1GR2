package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Inventory;
import com.l1gr2.restaurant.entity.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsers();

    void deleteUser(Users selectedItem);

    void addUser(Users user);

    String findUserAndGetRole(String login, String password);

    boolean checkUniqueness(String login);
}
