package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.repository.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StyleService {
    private final StyleRepository styleRepository;
}
