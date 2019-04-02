package com.bozhilov.boocarep.domain.models.service;

import com.bozhilov.boocarep.domain.entities.tech.EngineType;
import com.bozhilov.boocarep.domain.entities.users.User;
import com.bozhilov.boocarep.utils.Constants;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CarServiceModel {

    private String id;
    private String plateNumber;
    private String manufacturer;
    private String model;
    private Integer yearOfProduction;
    private String vin;
    private Integer currentMileage;
    private User owner;
    private EngineType engineType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotEmpty(message = Constants.PLATE_NUMBER_ERROR_MESSAGE)
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @NotEmpty(message = Constants.MANUFACTURER_ERROR_MESSAGE)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @NotEmpty(message = Constants.CAR_MODEL_ERROR_MESSAGE)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @NotNull(message = Constants.YEAR_OF_PRODUCTION_ERROR_MESSAGE)
    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @NotNull(message = Constants.CURRENT_MILEAGE_ERROR_MESSAGE)
    public Integer getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(Integer currentMileage) {
        this.currentMileage = currentMileage;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}
