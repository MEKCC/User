package com.example.user_project.service.util;

import com.example.user_project.entity.Gender;
import com.example.user_project.entity.UserEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InitUser {

    public static UserEntity getOneUser() {
        return UserEntity.builder()
                .login("login")
                .fullName("Maksym SecondName")
                .dateOfBirth(LocalDate.of(1991, 1, 9))
                .gender(Gender.MALE)
                .build();
    }

    public static List<UserEntity> getUsers() {
        List<UserEntity> users = new ArrayList<>();

        UserEntity firstUser = UserEntity.builder()
                .login("first")
                .fullName("Alex Karnov")
                .dateOfBirth(LocalDate.of(2000, 10, 5))
                .gender(Gender.MALE)
                .build();

        UserEntity secondUser = UserEntity.builder()
                .login("second")
                .fullName("Vika Polishuk")
                .dateOfBirth(LocalDate.of(1990, 3, 14))
                .gender(Gender.FEMALE)
                .build();

        users.add(firstUser);
        users.add(secondUser);

        return users;
    }
}
