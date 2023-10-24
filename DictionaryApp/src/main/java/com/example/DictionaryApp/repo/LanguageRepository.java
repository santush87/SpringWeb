package com.example.DictionaryApp.repo;

import com.example.DictionaryApp.model.entity.LanguageEntity;
import com.example.DictionaryApp.model.enums.LanguageName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, String> {

    LanguageEntity findByName(LanguageName name);
}
