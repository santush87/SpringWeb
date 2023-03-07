package com.softuni.Pathfinder.configuration;

import com.softuni.Pathfinder.helpers.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    @SessionScope
    public LoggedUser loggedUser(){
        return new LoggedUser();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests()
                // allow access to all static files (images, CSS, js)
                .requestMatchers(PathRequest
                        .toStaticResources()
                        .atCommonLocations()).permitAll()
                // the URL-s below are available for all users - logged in and anonymous
                .requestMatchers("/").permitAll()
                // the URL-s below are available for anonymous
                .requestMatchers("/auth/login", "/auth/register").anonymous()
                // the URL-s below are available for authenticated persons - (logged in)
                .requestMatchers("/auth/profile").authenticated();

        return httpSecurity.build();
    }
}
