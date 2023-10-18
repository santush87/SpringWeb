package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.dtos.SongDto;
import com.example.spotifyplaylistapp.model.dtos.SongHomeView;
import com.example.spotifyplaylistapp.model.dtos.SongViewDto;
import com.example.spotifyplaylistapp.model.entity.SongEntity;
import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.entity.UserEntity;
import com.example.spotifyplaylistapp.model.enums.StyleName;
import com.example.spotifyplaylistapp.repository.SongRepository;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import com.example.spotifyplaylistapp.repository.UserRepository;
import com.example.spotifyplaylistapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;
    private final StyleRepository styleRepository;
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

    public void addSong(SongDto songDto) {
        String username = this.loggedUser.getUsername();
        UserEntity user = this.userRepository.findByUsername(username);
        StyleEntity style = this.styleRepository.findByStyleName(songDto.getStyle());

        if (style != null) {
            SongEntity song = this.modelMapper.map(songDto, SongEntity.class);
            song.setStyle(style);
            song.setUserPlaylist(user);
            this.songRepository.save(song);
        }


    }

    public SongHomeView getHomeViewData(String username) {
        List<SongEntity> allSongs = this.songRepository.findAll();

        List<SongViewDto> myPlaylist = new ArrayList<>();
        List<SongViewDto> pop = new ArrayList<>();
        List<SongViewDto> rock = new ArrayList<>();
        List<SongViewDto> jazz = new ArrayList<>();

        for (SongEntity song : allSongs) {
            SongViewDto songToAdd = this.modelMapper.map(song, SongViewDto.class);
            if (song.getUserPlaylist().getUsername().equals(username)) {
                myPlaylist.add(songToAdd);
            } else if (song.getStyle().getStyleName().equals(StyleName.ROCK)) {
                rock.add(songToAdd);
            } else if (song.getStyle().getStyleName().equals(StyleName.POP)) {
                pop.add(songToAdd);
            } else if (song.getStyle().getStyleName().equals(StyleName.JAZZ)) {
                jazz.add(songToAdd);
            }
        }


        return new SongHomeView(myPlaylist, pop, rock, jazz);
    }
}
