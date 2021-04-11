package com.example.user_project.util;

import com.example.user_project.entity.Gender;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ValidationException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class ValidationUtils {

    public static void checkUserInfo(String login, LocalDate dateOfBirth, Gender gender) {
        checkLogin(login);
        checkDateOfBirth(dateOfBirth);
        checkGender(gender);
    }

    private static void checkLogin(String login) {
        if (StringUtils.isEmpty(login)) {
            String message = "login can't be empty";
            throw new ResponseStatusException(HttpStatus.CONFLICT, message);
        }
    }

    private static void checkGender(Gender gender) {
        String errorMessage = "gender should be \"MALE\" or \"FEMALE\"";
        Arrays.stream(Gender.values()).filter(value -> value.name().equals(gender.name()))
                .findAny().orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT, errorMessage));
    }

    private static void checkDateOfBirth(LocalDate dateOfBirth) {
        if (Objects.isNull(dateOfBirth)) {
            throw new ValidationException("date of birth can't be empty");
        }
        if (dateOfBirth.isAfter(LocalDate.now())) {
            throw new ValidationException("date of birth cannot be more than the current moment");
        }
    }
}
