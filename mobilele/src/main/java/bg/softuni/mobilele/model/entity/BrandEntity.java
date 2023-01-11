package bg.softuni.mobilele.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @OneToMany(mappedBy = "brand",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<ModelEntity> models = new ArrayList<>();

    public List<ModelEntity> getModels() {
        return models;
    }

    public BrandEntity setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "models=" + models +
                '}';
    }
}
