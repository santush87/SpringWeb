package bg.softuni.mobilele.model.entities;

import bg.softuni.mobilele.model.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity{

//    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public RoleEnum getRole() {
        return role;
    }

    public UserRole setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
