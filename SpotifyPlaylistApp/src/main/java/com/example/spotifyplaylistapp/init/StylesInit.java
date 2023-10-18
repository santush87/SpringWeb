package com.example.spotifyplaylistapp.init;

import com.example.spotifyplaylistapp.model.entity.StyleEntity;
import com.example.spotifyplaylistapp.model.enums.StyleName;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class StylesInit implements CommandLineRunner {

    private final StyleRepository styleRepository;
    @Override
    public void run(String... args) {
        boolean hasStyles = this.styleRepository.count() > 0;

        if (!hasStyles) {
            Set<StyleEntity> styles = new HashSet<>();

            Arrays.stream(StyleName.values())
                    .forEach(styleName -> {
                        StyleEntity style = new StyleEntity(styleName);
                        styles.add(style);
                    });

            this.styleRepository.saveAll(styles);
        }
    }
}
