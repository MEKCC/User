package util;

import com.example.user_project.domain.Gender;
import com.example.user_project.domain.User;

import java.time.LocalDate;

public class InitUser {

    public static User getOneUser() {
        return User.builder()
                .login("first")
                .fullName("Maksym SecondName")
                .dateOfBirth(LocalDate.of(1991, 1, 9))
                .gender(Gender.MALE)
                .build();
    }
}
