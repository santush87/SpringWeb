package com.likebookapp.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostHomeView {

    private List<PostViewDto> myPosts;
    private List<PostViewDto> othersPosts;
    private int othersPostsCount;

    public PostHomeView() {
        this.myPosts = new ArrayList<>();
        this.othersPosts = new ArrayList<>();
    }

    public PostHomeView(List<PostViewDto> myPosts, List<PostViewDto> othersPosts) {
        this.myPosts = myPosts;
        this.othersPosts = othersPosts;
        this.othersPostsCount = othersPosts.size();
    }
}
