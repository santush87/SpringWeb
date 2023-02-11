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
    @Column
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Role> roles;
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column
    private String fullName;

    @Column
    private Integer age;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String userName) {
        this.username = userName;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> role) {
        this.roles = role;
        return this;
    }

    public Level getLevel() {
        return level;
    }

    public User setLevel(Level level) {
        this.level = level;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }
}
