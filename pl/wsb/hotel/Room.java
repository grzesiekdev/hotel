package pl.wsb.hotel;


public class Room {
    private String id;
    private String description;
    private Double area;
    private Integer floor;
    private Boolean hasKingSizeBed;
    private Integer numberOfBeds;
    private Integer price;
    private Boolean isFurnished;

    public Room(String id, String description, Double area, Integer floor, Boolean hasKingSizeBed, Integer price, Boolean isFurnished) {
        this.id = id;
        this.description = description;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.price = price;
        this.isFurnished = isFurnished;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }
}
