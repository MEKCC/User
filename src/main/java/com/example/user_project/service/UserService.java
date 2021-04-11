package com.example.user_project.service;

import com.example.user_project.entity.Gender;
import com.example.user_project.entity.UserEntity;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();

    void addUser(String login, String fullName, LocalDate dateOfBirth, Gender gender);

    void updateUser(Integer id, String login, String fullName, LocalDate dateOfBirth, Gender gender);

}
