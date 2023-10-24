package com.example.DictionaryApp.repo;

import com.example.DictionaryApp.model.entity.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, String> {
}
