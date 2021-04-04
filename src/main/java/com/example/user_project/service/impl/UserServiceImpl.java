package com.example.user_project.service.impl;

import com.example.user_project.domain.Gender;
import com.example.user_project.domain.User;
import com.example.user_project.repo.UserRepo;
import com.example.user_project.service.UserService;
import com.example.user_project.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void addUser(String login, String fullName, LocalDate dateOfBirth, Gender gender) {
        ValidationUtils.checkUserInfo(login, dateOfBirth, gender);

        if (userRepo.findByLogin(login) != null) {
            String message = "user with the same login already exists, please choose another login";
            throw new ResponseStatusException(HttpStatus.CONFLICT, message);
        }

        User user = User.builder()
                .login(login)
                .fullName(fullName)
                .dateOfBirth(dateOfBirth)
                .gender(gender)
                .build();

        userRepo.save(user);
    }

    @Override
    public void updateUser(Integer id, User updatedUser) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.setLogin(updatedUser.getLogin());
        user.setFullName(updatedUser.getFullName());
        user.setDateOfBirth(updatedUser.getDateOfBirth());
        user.setGender(updatedUser.getGender());
        userRepo.save(user);
    }
}
