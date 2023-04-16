package com.springboot.assignment.magicofbooks.dao;

import com.springboot.assignment.magicofbooks.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {
    public Users findByemailIgnoreCase(String email);

    Users findByusernameIgnoreCase(String username);
}
