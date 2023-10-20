package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "moods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoodEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private MoodName moodName;

    @OneToMany(mappedBy = "mood")
    private Set<PostEntity> posts;

    public MoodEntity(MoodName moodName) {
        this.moodName = moodName;
        this.posts = new HashSet<>();
    }
}
