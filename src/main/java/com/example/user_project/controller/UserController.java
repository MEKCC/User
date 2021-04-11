package com.example.user_project.controller;

import com.example.user_project.entity.UserEntity;
import com.example.user_project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody UserEntity user) {
        userService.addUser(user.getLogin(), user.getFullName(), user.getDateOfBirth(), user.getGender());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Integer id, @RequestBody UserEntity user) {
        userService.updateUser(id, user.getLogin(), user.getFullName(), user.getDateOfBirth(), user.getGender());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

