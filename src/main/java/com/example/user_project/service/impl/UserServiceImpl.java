package com.example.user_project.service.impl;

import com.example.user_project.entity.Gender;
import com.example.user_project.entity.UserEntity;
import com.example.user_project.exception.LoginAlreadyExistsException;
import com.example.user_project.exception.UserNotFoundException;
import com.example.user_project.repo.UserRepo;
import com.example.user_project.service.UserService;
import com.example.user_project.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void addUser(String login, String fullName, LocalDate dateOfBirth, Gender gender) {
        ValidationUtils.checkUserInfo(login, dateOfBirth, gender);

        if (userRepo.findByLogin(login) != null) {
            throw new LoginAlreadyExistsException("User with the same login already exists, please choose another login");
        }

        UserEntity user = UserEntity.builder()
                .login(login)
                .fullName(fullName)
                .dateOfBirth(dateOfBirth)
                .gender(gender)
                .build();

        userRepo.save(user);
    }

    @Override
    public void updateUser(Integer id, String login, String fullName, LocalDate dateOfBirth, Gender gender) {
        ValidationUtils.checkUserInfo(login, dateOfBirth, gender);

        UserEntity user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with such ID does not exist"));
        user.setLogin(login);
        user.setFullName(fullName);
        user.setDateOfBirth(dateOfBirth);
        user.setGender(gender);
        userRepo.save(user);
    }
}
