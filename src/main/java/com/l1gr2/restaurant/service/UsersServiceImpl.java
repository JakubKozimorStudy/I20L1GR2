package com.l1gr2.restaurant.service;


import com.l1gr2.restaurant.entity.Users;
import com.l1gr2.restaurant.repository.UsersRepository;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsersServiceImpl implements UsersService {


    UsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void deleteUser(Users selectedItem) {
        usersRepository.delete(selectedItem);
    }

    @Override
    public void addUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    public String findUserAndGetRole(String login, String password) {
        String role ="";
        Optional<Users> userFromDatabase = usersRepository.findById(login);
        if(userFromDatabase.isPresent()){
            Users userToCheck = userFromDatabase.get();
            if(userToCheck.getPassword().equals(password)){
                role = userToCheck.getRole();
            }
        }
        return role;
    }

    @Override
    public boolean checkUniqueness(String login) {
        return usersRepository.findById(login).isPresent();
    }
}
