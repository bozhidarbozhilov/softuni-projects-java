package com.bozhilov.boocarep.service.car;

import com.bozhilov.boocarep.domain.entities.tech.Car;
import com.bozhilov.boocarep.domain.models.service.CarServiceModel;
import com.bozhilov.boocarep.repository.CarRepository;
import com.bozhilov.boocarep.utils.Constants;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.io.InvalidObjectException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Validator validator;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ModelMapper modelMapper, Validator validator) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public CarServiceModel saveCar(CarServiceModel carServiceModel) throws InvalidObjectException {
        if(validator.validate(carServiceModel).size()>0){
            throw new InvalidObjectException(Constants.CAR_INVALID_MODEL_MESSAGE);
        }

        Car savedCar = this.carRepository.save(this.modelMapper.map(carServiceModel, Car.class));

        return this.modelMapper.map(savedCar, CarServiceModel.class);
    }

    @Override
    public List<CarServiceModel> findAllCars() {
        return this.carRepository.findAll().stream()
                .map(car -> this.modelMapper.map(car, CarServiceModel.class))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public CarServiceModel findCarById(String id) {
        Car foundCar = this.carRepository.findById(id)
                .orElseThrow(()->new NullPointerException("Car not found."));

        return this.modelMapper.map(foundCar, CarServiceModel.class);
    }
}
