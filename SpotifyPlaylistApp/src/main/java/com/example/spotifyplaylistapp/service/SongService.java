package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SongService {
    private final SongRepository songRepository;
}
