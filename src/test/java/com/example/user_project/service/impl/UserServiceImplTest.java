package com.example.user_project.service.impl;

import com.example.user_project.entity.Gender;
import com.example.user_project.entity.UserEntity;
import com.example.user_project.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.user_project.service.util.InitUser.getOneUser;
import static com.example.user_project.service.util.InitUser.getUsers;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    private static final UserEntity USER = getOneUser();

    private static final Integer ID = 1;
    private static final String LOGIN = USER.getLogin();
    private static final String FULL_NAME = USER.getFullName();
    private static final LocalDate DATE_OF_BIRTH = USER.getDateOfBirth();
    private static final Gender GENDER = USER.getGender();

    private static final List<UserEntity> USERS = getUsers();

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    void addUser_ifParametersAreCorrect() {
        when(userRepo.findByLogin(anyString())).thenReturn(null);
        userServiceImpl.addUser(LOGIN, FULL_NAME, DATE_OF_BIRTH, GENDER);
        verify(userRepo, times(1)).save(USER);
    }

    @Test
    void updateUser_ifParametersAreCorrect() {
        when(userRepo.findById(anyInt())).thenReturn(Optional.ofNullable(USER));
        userServiceImpl.updateUser(ID, LOGIN, FULL_NAME, DATE_OF_BIRTH, GENDER);
        verify(userRepo, times(1)).save(eq(USER));
    }

    @Test
    void getAllUsers() {
        when(userRepo.findAll()).thenReturn(USERS);
        List<UserEntity> allUsers = userServiceImpl.getAllUsers();
        assertEquals(2, allUsers.size());
        assertEquals("Alex Karnov", allUsers.get(0).getFullName());
        assertEquals("Vika Polishuk", allUsers.get(1).getFullName());
    }
}
