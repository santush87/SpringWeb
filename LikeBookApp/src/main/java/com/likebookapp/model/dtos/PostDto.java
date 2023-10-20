package com.likebookapp.model.dtos;

import com.likebookapp.model.enums.MoodName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    @Size(min = 2, max = 150, message = "Content length must be between 2 and 50 characters!")
    private String content;

    @NotNull(message = "You must select a mood!")
    private MoodName mood;
}
