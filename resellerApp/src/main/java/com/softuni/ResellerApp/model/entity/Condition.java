package com.softuni.ResellerApp.model.entity;

import com.softuni.ResellerApp.model.enums.ConditonType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "conditons")
public class Condition {

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true,nullable = false)
    private ConditonType name;

    @Column(nullable = false)
    private String description;

    public Condition(ConditonType conditonType) {
    }

//    @OneToMany(mappedBy = "condition")
//    private Offer offer;

}
