package com.example.spotifyplaylistapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class SongHomeView {

    private List<SongViewDto> myPlaylist;
    private List<SongViewDto> pop;
    private List<SongViewDto> rock;
    private List<SongViewDto> jazz;
    private int totalDuration;

    public SongHomeView() {
        this.myPlaylist = new ArrayList<>();
        this.pop = new ArrayList<>();
        this.rock = new ArrayList<>();
        this.jazz = new ArrayList<>();
        this.totalDuration = 0;
    }

    public SongHomeView(List<SongViewDto> myPlaylist, List<SongViewDto> pop, List<SongViewDto> rock, List<SongViewDto> jazz) {
        this.myPlaylist = myPlaylist;
        this.pop = pop;
        this.rock = rock;
        this.jazz = jazz;
        setTotalDuration(myPlaylist);
    }

    public SongHomeView setTotalDuration(List<SongViewDto> myPlaylist) {
        int number = 0;
        for (SongViewDto song : myPlaylist) {
            number += song.getDuration();
        }
        this.totalDuration = number;
        return this;
    }
}
