package com.likebookapp.repository;

import com.likebookapp.model.entity.MoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MoodRepository extends JpaRepository<MoodEntity, UUID> {
}

