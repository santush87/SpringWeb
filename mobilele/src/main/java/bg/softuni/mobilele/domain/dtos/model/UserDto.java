package bg.softuni.mobilele.domain.dtos.model;

import bg.softuni.mobilele.domain.entities.UserRole;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDto extends BaseEntityDto {


    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    private List<UserRole> userRoles = new ArrayList<>();
    private String imageUrl;
    private Date created;

    private Date modified;

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserDto setActive(boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public UserDto setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public UserDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public UserDto setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public UserDto setModified(Date modified) {
        this.modified = modified;
        return this;
    }
}
