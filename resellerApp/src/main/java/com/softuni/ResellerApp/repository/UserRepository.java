package com.softuni.ResellerApp.repository;

import com.softuni.ResellerApp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);

    @Override
    Optional<User> findById(String id);

    Optional<User> findByIdNot(String id);

    Optional<User> findByEmail(String email);
}
