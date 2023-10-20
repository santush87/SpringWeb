package com.likebookapp.model.dtos;

import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.model.enums.MoodName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostViewDto {

    private UUID id;
    private MoodName moodName;
    private int likes;
    private String content;
    private UserEntity user;

}
