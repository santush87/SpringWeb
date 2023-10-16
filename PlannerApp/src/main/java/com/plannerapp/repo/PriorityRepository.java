package com.plannerapp.repo;

import com.plannerapp.model.entity.PriorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PriorityRepository extends JpaRepository<PriorityEntity, UUID> {
}
