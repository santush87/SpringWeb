package com.softuni.Pathfinder.repository;

import com.softuni.Pathfinder.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends JpaRepository<User, Long> {
}
