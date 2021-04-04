package com.example.user_project.service;

import com.example.user_project.domain.Gender;
import com.example.user_project.domain.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void addUser(String login, String fullName, LocalDate dateOfBirth, Gender gender);
    void updateUser(Integer id, User updatedUser);

}
