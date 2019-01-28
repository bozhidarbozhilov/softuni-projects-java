package app.models.dtos.view;


/*    "Id": 117,
            "Make": "Toyota",
            "Model": "Camry Hybrid",
            "TravelledDistance": 954775807,*/

public class FindByMakerCarDto {
    private long id;
    private String make;
    private String model;
    private long travelledDistance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }
}
