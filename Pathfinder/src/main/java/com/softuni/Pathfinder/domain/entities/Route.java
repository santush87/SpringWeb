package com.softuni.Pathfinder.domain.entities;

import com.softuni.Pathfinder.domain.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(columnDefinition = "LONGTEXT")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private Level level;

    @Column
    private String name;

    @ManyToOne
    private User author;

    @Column
    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(targetEntity = Comment.class,
            mappedBy = "route",
            cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<Comment> comments;

    @OneToMany(targetEntity = Picture.class,
            mappedBy = "route",
            cascade = {CascadeType.MERGE, CascadeType.DETACH})
    private Set<Picture> pictures;

    @ManyToMany
    private Set<Category> categories;

    public Route() {
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public Route setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Route setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Route setComments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public Route setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Route setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
