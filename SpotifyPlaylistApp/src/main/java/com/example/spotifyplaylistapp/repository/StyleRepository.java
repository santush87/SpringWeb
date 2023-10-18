package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.StyleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StyleRepository extends JpaRepository<StyleEntity, UUID> {
    StyleEntity findByStyleName(StyleName style);
}
