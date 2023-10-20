package com.likebookapp.service;

import com.likebookapp.model.dtos.PostDto;
import com.likebookapp.model.dtos.PostHomeView;
import com.likebookapp.model.dtos.PostViewDto;
import com.likebookapp.model.entity.MoodEntity;
import com.likebookapp.model.entity.PostEntity;
import com.likebookapp.model.entity.UserEntity;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.util.LoggedUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final MoodRepository moodRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;

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

    public PostHomeView getHomeViewData(String username) {
        List<PostEntity> allPosts = this.postRepository.findAll();

        List<PostViewDto> myPosts = new ArrayList<>();
        List<PostViewDto> othersPosts = new ArrayList<>();

        for (PostEntity post : allPosts) {
            PostViewDto postToAdd = this.modelMapper.map(post, PostViewDto.class);
            if (post.getUser().getUsername().equals(username)){
                myPosts.add(postToAdd);
            } else {
                othersPosts.add(postToAdd);
            }
        }

        return new PostHomeView(myPosts,othersPosts);
    }
}
