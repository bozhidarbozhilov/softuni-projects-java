package app.services.interfaces;

import app.models.dtos.binding.CreateCarDto;
import app.models.dtos.view.CarsPartListDto;
import app.models.dtos.view.FindByMakerCarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    void createCar(CreateCarDto createCarDto);
    void createAllCars(List<CreateCarDto> createCarDtos);

    List<FindByMakerCarDto> findCarsByMaker(String maker);

    List<CarsPartListDto> getCarsAndTheirParts();
}
