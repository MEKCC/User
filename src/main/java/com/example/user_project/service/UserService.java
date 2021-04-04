package com.example.user_project.service;

import antlr.StringUtils;
import com.example.user_project.domain.User;
import com.example.user_project.repo.UserRepo;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void addUser(String login, String fullName, LocalDate dateOfBirth, String gender) {

        if (userRepo.findByLogin(login) != null) {
            String message = "user with the same login is already exist, please choose another login";
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

    public void updateUser(Integer id, User updatedUser) {
        Optional<User> foundedUser = userRepo.findById(id);
        User user = foundedUser.get();

        user.setLogin(updatedUser.getLogin());
        user.setFullName(updatedUser.getFullName());
        user.setDateOfBirth(updatedUser.getDateOfBirth());
        user.setGender(updatedUser.getGender());
        userRepo.save(user);


//        User user = User.builder()
//                .id(id)
//                .login(updatedUser.getLogin())
//                .fullName(updatedUser.getFullName())
//                .dateOfBirth(updatedUser.getDateOfBirth())
//                .gender(updatedUser.getGender())
//                .build();
//
//        userRepo.save(user);
//        Optional<User> foundedUser = userRepo.findById(user.getId());

    }

//    private void checkUserInfo(String login, String dateOfBirth, String gender) {
//        checkLogin(login);
//        checkDateOfBirth(dateOfBirth);
//        checkGender(gender);
//    }
//
//    private void checkLogin(String login) {
//        if (login.isEmpty()) {
//            String message = "login can't be empty";
//            throw new ResponseStatusException(HttpStatus.CONFLICT, message);
//        }
//    }
//
//    private void checkGender(String gender) {
//        if (!gender.toLowerCase().equals("Man".toLowerCase()) || !gender.toLowerCase().equals("Woman".toLowerCase())) {
//            String message = "gender should be \"Male\" or \"Female\"";
//            throw new ResponseStatusException(HttpStatus.CONFLICT, message);
//        }
//    }
//
//    private void checkDateOfBirth(String dateOfBirth) {
//
//    }
}
