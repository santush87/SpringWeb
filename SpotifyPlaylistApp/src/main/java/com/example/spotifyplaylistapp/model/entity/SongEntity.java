package com.example.spotifyplaylistapp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "songs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongEntity extends BaseEntity{

    @Column(nullable = false)
    @Size(min = 3,max = 20)
    private String performer;

    @Column(nullable = false)
    @Size(min = 2,max = 20)
    private String title;

    @Column(nullable = false)
    @Positive
    private int duration;

    @Column
    @PastOrPresent
    private LocalDate releaseDate;

    @ManyToOne
    @NotNull
    private StyleEntity style;

    @ManyToOne
    private UserEntity userPlaylist;
}
