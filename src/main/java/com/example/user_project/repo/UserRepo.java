package com.example.user_project.repo;

import com.example.user_project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    UserEntity findByLogin(String login);
}
