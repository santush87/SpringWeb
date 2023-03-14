package bg.softuni.mobilele.domain.entities;

import bg.softuni.mobilele.domain.enums.ModelCategoryEnum;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private ModelCategoryEnum category;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Integer startYear;

    @Column
    private Integer endYear;
    @Column
    private Date created;

    @Column
    private Date modified;

    @ManyToOne
    private BrandEntity brandEntity;

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public ModelCategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(ModelCategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public ModelEntity setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public ModelEntity setModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public BrandEntity getBrand() {
        return brandEntity;
    }

    public ModelEntity setBrand(BrandEntity brandEntity) {
        this.brandEntity = brandEntity;
        return this;
    }
}
