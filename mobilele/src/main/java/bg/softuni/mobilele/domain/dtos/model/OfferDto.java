package bg.softuni.mobilele.domain.dtos.model;


import bg.softuni.mobilele.domain.enums.EngineEnum;
import bg.softuni.mobilele.domain.enums.TransmissionEnum;
import java.math.BigDecimal;

public class OfferDto extends BaseEntityDto {

    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private TransmissionEnum transmission;
    private int year;

    public String getDescription() {
        return description;
    }

    public OfferDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferDto setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferDto setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDto setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferDto setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferDto setYear(int year) {
        this.year = year;
        return this;
    }
}
