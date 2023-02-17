package com.softuni.battleShips.domain.services;

import com.softuni.battleShips.domain.entities.Category;
import com.softuni.battleShips.domain.enums.CategoryEnum;
import com.softuni.battleShips.domain.models.CategoryModel;
import com.softuni.battleShips.domain.repositories.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void postConstruct() {
        if (this.categoryRepository.count() == 0) {

            this.categoryRepository.saveAllAndFlush(Arrays.stream(CategoryEnum.values())
                    .map(categoryEnum -> CategoryModel.builder()
                            .name(categoryEnum)
                            .description("Fight me")
                            .build())
                    .map(categoryModel -> this.modelMapper.map(categoryModel, Category.class)).toList());
        }
    }

    public CategoryModel findByName(CategoryEnum name){
        return this.modelMapper.map(this.categoryRepository.findByName(name).orElseThrow(),
                CategoryModel.class);
    }
}
