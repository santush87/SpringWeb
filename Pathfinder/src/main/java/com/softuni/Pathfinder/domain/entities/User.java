package com.softuni.Pathfinder.domain.entities;

import com.softuni.Pathfinder.domain.enums.Level;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> role;
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column
    private String fullname;

    @Column
    private Integer age;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Role> getRole() {
        return role;
    }

    public User setRole(Set<Role> role) {
        this.role = role;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public User setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public Integer getAge() {
        return age;
    }
}
