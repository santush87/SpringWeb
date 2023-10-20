package com.likebookapp.init;

import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.enums.MoodName;
import com.likebookapp.repository.MoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class MoodInit implements CommandLineRunner {

    private final MoodRepository moodRepository;

    @Override
    public void run(String... args) {
        boolean hasMood = this.moodRepository.count() > 0;

        if (!hasMood) {
            Set<MoodEntity> moods = new HashSet<>();

            Arrays.stream(MoodName.values())
                    .forEach(moodName -> {
                        MoodEntity mood = new MoodEntity(moodName);
                        moods.add(mood);
                    });

            this.moodRepository.saveAll(moods);
        }
    }
}
