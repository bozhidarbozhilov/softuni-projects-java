package com.bozhilov.boocarep.domain.entities.tech;

import com.bozhilov.boocarep.domain.entities.BaseEntity;
import com.bozhilov.boocarep.domain.entities.users.User;
import com.bozhilov.boocarep.utils.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cars")
public class Car extends BaseEntity {
    private String plateNumber;
    private String manufacturer;
    private String model;
    private Integer yearOfProduction;
    private String vin;
    private Integer currentMileage;
    private User owner;
    private EngineType engineType;

    @NotEmpty(message = Constants.PLATE_NUMBER_ERROR_MESSAGE)
    @Column(name="plate_number", nullable = false, unique = true)
    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @NotEmpty(message = Constants.MANUFACTURER_ERROR_MESSAGE)
    @Column(name="manufacturer", nullable=false)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @NotEmpty(message = Constants.CAR_MODEL_ERROR_MESSAGE)
    @Column(name="model", nullable=false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @NotNull(message = Constants.YEAR_OF_PRODUCTION_ERROR_MESSAGE)
    @Column(name="year_of_production", nullable = false)
    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Basic
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @NotNull(message = Constants.CURRENT_MILEAGE_ERROR_MESSAGE)
    @Column(name="current_mileage", nullable = false)
    public Integer getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(Integer currentMileage) {
        this.currentMileage = currentMileage;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name="owner_id", referencedColumnName = "id", nullable = false)
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Enumerated(EnumType.STRING)
    @Column(name="engine_type")
    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}
