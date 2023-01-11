package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column
    private CategoryEnum category;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Long startYear;

    @Column
    private Long endYear;

    @ManyToOne
    private BrandEntity brand;

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelEntity setCategory(CategoryEnum category) {
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

    public Long getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(Long startYear) {
        this.startYear = startYear;
        return this;
    }

    public Long getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Long endYear) {
        this.endYear = endYear;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public String toString() {
        return "ModelEntity{" +
                "category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + (brand != null ? brand.getName() : null) +
                '}';
    }
}
