package com.likebookapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends BaseEntity{

    @Column(nullable = false)
    @Size(min = 2, max = 150)
    private String content;

    @ManyToOne
    @NotNull
    private UserEntity user;

    @Column
    private int likes;

    @ManyToMany
    @NotNull
    private Set<UserEntity> userLikes;

    @ManyToOne
    @NotNull
    private MoodEntity mood;
}
