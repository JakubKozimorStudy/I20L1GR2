package com.l1gr2.restaurant.service;

import com.l1gr2.restaurant.entity.Users;

import java.util.List;

public interface UsersService {

    List<Users> getAllUsers();

    void deleteUser(Users selectedItem);
}
