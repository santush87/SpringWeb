package com.resellerapp.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
//    @Size(min = 3, max = 20)
    private String password;

    @Column(unique = true, nullable = false)
    @Email
    private String email;

    @OneToMany(mappedBy = "createdBy")
    private Set<OfferEntity> offers;

    @OneToMany(mappedBy = "boughtBy")
    private Set<OfferEntity> boughtOffers;


    public UserEntity() {
        this.offers = new HashSet<>();
        this.boughtOffers = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<OfferEntity> getOffers() {
        return offers;
    }

    public UserEntity setOffers(Set<OfferEntity> offers) {
        this.offers = offers;
        return this;
    }

    public Set<OfferEntity> getBoughtOffers() {
        return boughtOffers;
    }

    public UserEntity setBoughtOffers(Set<OfferEntity> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }
}
