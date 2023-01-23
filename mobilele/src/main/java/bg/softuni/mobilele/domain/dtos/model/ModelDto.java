package bg.softuni.mobilele.domain.dtos.model;


import bg.softuni.mobilele.domain.entities.Brand;
import bg.softuni.mobilele.domain.enums.ModelCategoryEnum;
import java.util.Date;

public class ModelDto extends BaseEntityDto {

    private String name;


    private ModelCategoryEnum category;

    private String imageUrl;

    private Integer startYear;

    private Integer endYear;
    private Date created;

    private Date modified;

    private Brand brand;

    public String getName() {
        return name;
    }

    public ModelDto setName(String name) {
        this.name = name;
        return this;
    }

    public ModelCategoryEnum getCategory() {
        return category;
    }

    public ModelDto setCategory(ModelCategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelDto setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelDto setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public ModelDto setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public ModelDto setModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public ModelDto setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
