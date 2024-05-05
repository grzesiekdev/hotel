package pl.wsb.hotel;


import java.util.UUID;

public class Room {
    private String id;
    private String description;
    private Double area;
    private Integer floor;
    private Boolean hasKingSizeBed;
    private Integer numberOfBeds;
    private Integer price;
    private Boolean isFurnished;

    @Override
    public String toString() {
        return "Room{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Room(Double area, Integer floor, Boolean hasKingSizeBed, String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Boolean getHasKingSizeBed() {
        return hasKingSizeBed;
    }

    public void setHasKingSizeBed(Boolean hasKingSizeBed) {
        this.hasKingSizeBed = hasKingSizeBed;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getFurnished() {
        return isFurnished;
    }

    public void setFurnished(Boolean furnished) {
        isFurnished = furnished;
    }
}
