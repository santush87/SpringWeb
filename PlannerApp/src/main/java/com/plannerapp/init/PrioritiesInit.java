package com.plannerapp.init;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.enums.PriorityName;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PrioritiesInit implements CommandLineRunner {

    private final PriorityRepository priorityRepository;

    public PrioritiesInit(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) {
        boolean hasPriorities = this.priorityRepository.count() > 0;

        if (!hasPriorities){
            List<PriorityEntity> priorities = new ArrayList<>();

            Arrays.stream(PriorityName.values())
                    .forEach(priorityName -> {
                        PriorityEntity priority = new PriorityEntity(priorityName);

                        priorities.add(priority);
                    });

            this.priorityRepository.saveAll(priorities);
        }
    }
}
