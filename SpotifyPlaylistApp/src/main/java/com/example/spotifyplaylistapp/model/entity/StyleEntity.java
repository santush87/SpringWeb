package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "styles")
@Getter
@Setter
@AllArgsConstructor
public class StyleEntity extends BaseEntity{

    @Column(unique = true,nullable = false)
    @Enumerated(EnumType.STRING)
    private StyleName styleName;

    @Column
    private String description;

    @OneToMany(mappedBy = "style")
    private Set<SongEntity> songs;

    public StyleEntity() {
        this.songs = new HashSet<>();
    }
}
