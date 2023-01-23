package bg.softuni.mobilele.domain.dtos.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntityDto {

    private String id;

    public BaseEntityDto() {
    }

    public String getId() {
        return id;
    }

    public BaseEntityDto setId(String id) {
        this.id = id;
        return this;
    }
}