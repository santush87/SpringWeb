package com.likebookapp.repository;

import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.enums.MoodName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MoodRepository extends JpaRepository<MoodEntity, UUID> {

    MoodEntity findByMoodName(MoodName moodName);
}

