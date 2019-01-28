package app.models.dtos.view;

import app.models.entities.Part;

import java.util.Set;

public class CarsPartListDto {
    private String make;
    private String model;
    private long travelledDistance;
    private Set<BasePartDto> parts;

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

    public Set<BasePartDto> getParts() {
        return parts;
    }

    public void setParts(Set<BasePartDto> parts) {
        this.parts = parts;
    }
}
