package com.example.DictionaryApp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "words")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordEntity extends BaseEntity{

    @Column(nullable = false)
    @Size(min = 2, max = 40)
    private String term;

    @Column(nullable = false)
    @Size(min = 2, max = 80)
    private String translation;

    @Column(columnDefinition = "TEXT")
    @Size(min = 2, max = 200)
    private String example;

    @Column(nullable = false)
    @PastOrPresent
    private LocalDate inputDate;

    @ManyToOne
    @NotNull
    private LanguageEntity language;

    @ManyToOne
    private UserEntity addedBy;
}
