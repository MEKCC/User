package com.example.user_project.service.util;

import com.example.user_project.domain.Gender;
import com.example.user_project.domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InitUser {

    public static User getOneUser() {
        return User.builder()
                .login("login")
                .fullName("Maksym SecondName")
                .dateOfBirth(LocalDate.of(1991, 1, 9))
                .gender(Gender.MALE)
                .build();
    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();

        User firstUser = User.builder()
                .login("first")
                .fullName("Alex Karnov")
                .dateOfBirth(LocalDate.of(2000, 10, 5))
                .gender(Gender.MALE)
                .build();

        User secondUser = User.builder()
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
