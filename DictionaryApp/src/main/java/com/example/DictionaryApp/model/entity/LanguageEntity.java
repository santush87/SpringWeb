package com.example.DictionaryApp.model.entity;

import com.example.DictionaryApp.model.enums.LanguageName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "languagies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language")
    private Set<WordEntity> words;

    public LanguageEntity(LanguageName name) {
        this.name = name;
        setDescription(name);
        this.words = new HashSet<>();
    }

    public LanguageEntity setDescription(LanguageName name) {
        String currName = "";
        switch (name) {
            case FRENCH ->
                    currName = "A Romance language spoken worldwide, known for its elegance and cultural richness. It's the official language of France and numerous nations, famed for its cuisine, art, and literature.";
            case GERMAN ->
                    currName = "A West Germanic language, is spoken by over 90 million people worldwide. Known for its complex grammar and compound words, it's the official language of Germany and widely used in Europe.";
            case ITALIAN ->
                    currName = "A Romance language spoken in Italy and parts of Switzerland, with rich cultural heritage. Known for its melodious sounds, it's a gateway to Italian art, cuisine, and history.";
            case SPANISH ->
                    currName = "A Romance language, is spoken by over 460 million people worldwide. It boasts a rich history, diverse dialects, and is known for its melodious sound, making it a global cultural treasure.";
        }

        this.description = currName;
        return this;
    }
}
