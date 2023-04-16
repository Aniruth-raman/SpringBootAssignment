package com.springboot.assignment.magicofbooks.service;

import com.springboot.assignment.magicofbooks.dao.UserRepository;
import com.springboot.assignment.magicofbooks.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UserRepository database;

    public boolean validateUser(Users user) {
        Users usr = database.findByemailIgnoreCase(user.getEmail());
        System.out.println(usr.getPassword().equals(user.getPassword()));
        return usr.getPassword().equals(user.getPassword());

    }

    public void registerUser(Users user) {
        System.out.println(user);
        database.save(user);
    }

    public Users findByEmail(String email) {
        return database.findByemailIgnoreCase(email);
    }

    public Users findByUsername(String username) {
    return database.findByusernameIgnoreCase(username);
    }
}
