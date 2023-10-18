package com.example.spotifyplaylistapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongViewDto {

    private UUID id;
    private String performer;
    private String title;
    private int duration;
}
