package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StyleRepository extends JpaRepository<StyleEntity, UUID> {
}
