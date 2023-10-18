package com.example.spotifyplaylistapp.model.dtos;

import com.example.spotifyplaylistapp.model.enums.StyleName;
import com.example.spotifyplaylistapp.util.annotation.StringDateInPastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
    @Size(min = 3, max = 20, message = "Performer name length must be between 3 and 20 characters!")
    @NotNull
    private String performer;

    @Size(min = 2, max = 20, message = "Performer name length must be between 2 and 20 characters!")
    @NotNull
    private String title;

    @Positive(message = "Duration must be positive!")
    @NotNull
    private int duration;

    @StringDateInPastOrPresent(message = "Date cannot be in the future!")
    private String releaseDate;

    @NotNull(message = "You must select a style!")
    private StyleName style;
}
