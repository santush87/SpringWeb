package com.softuni.ResellerApp.repository;

import com.softuni.ResellerApp.model.entity.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditonRepository extends JpaRepository<Condition, String> {
}
