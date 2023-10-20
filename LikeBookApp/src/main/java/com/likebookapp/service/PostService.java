package com.likebookapp.service;

import com.likebookapp.model.dtos.PostDto;
import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.entity.PostEntity;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final MoodRepository moodRepository;
    private final LoggedUser loggedUser;

    public void addPost(PostDto postDto){
        UserEntity user = this.userRepository.findByUsername(this.loggedUser.getUsername());
        MoodEntity mood = this.moodRepository.findByMoodName(postDto.getMood());

        PostEntity post = new PostEntity();
        Set<UserEntity> userLikes = new HashSet<>();

        post.setContent(postDto.getContent());
        post.setMood(mood);
        post.setUser(user);
        post.setLikes(0);
        post.setUserLikes(userLikes);

        this.postRepository.save(post);
    }
}
