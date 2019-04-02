package com.bozhilov.boocarep.service.car;

import com.bozhilov.boocarep.domain.models.service.CarServiceModel;

import java.io.InvalidObjectException;
import java.util.List;

public interface CarService {
    CarServiceModel saveCar(CarServiceModel carServiceModel) throws InvalidObjectException;
    List<CarServiceModel> findAllCars();
    CarServiceModel findCarById(String id);
}
