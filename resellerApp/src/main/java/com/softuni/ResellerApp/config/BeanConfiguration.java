package com.softuni.ResellerApp.config;


import com.softuni.ResellerApp.util.LoggedUser;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        final ModelMapper mapper = new ModelMapper();

//        mapper.addConverter(new Converter<String, LocalDate>() {
//            @Override
//            public LocalDate convert(MappingContext<String, LocalDate> context) {
//                return LocalDate.parse(context.getSource(),
//                        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//            }
//        });
        return mapper;
    }

    @Bean
    @SessionScope
    public LoggedUser loggedUser(){
        return new LoggedUser();
    }
}
