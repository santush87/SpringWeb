package com.likebookapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<PostEntity> posts;

    @ManyToMany(mappedBy = "userLikes", fetch = FetchType.EAGER)
    private Set<PostEntity> likedPosts;
}
