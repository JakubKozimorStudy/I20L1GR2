package com.l1gr2.restaurant.reports;

import com.l1gr2.restaurant.entity.Users;

import java.util.List;
import java.util.stream.Collectors;

public class UsersTypeMapper {

    public List<reports.Users> getUsersToReports(List<Users> usersList) {
        return usersList.stream()
                .map(user -> new reports.Users(user.getLogin(), user.getFullname(), user.getPassword(), user.getRole()))
                .collect(Collectors.toList());
    }
}
