package app.services.implementation;

import app.models.dtos.binding.CreateCarDto;
import app.models.dtos.view.CarsPartListDto;
import app.models.dtos.view.FindByMakerCarDto;
import app.models.entities.Car;
import app.models.entities.Part;
import app.repositories.CarRepository;
import app.repositories.PartRepository;
import app.services.interfaces.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private PartRepository partRepository;
    private ModelMapper mapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          PartRepository partRepository,
                          ModelMapper mapper) {
        this.carRepository = carRepository;
        this.partRepository = partRepository;
        this.mapper = mapper;
    }

    @Override
    public void createCar(CreateCarDto createCarDto) {
        List<Part> allParts = this.partRepository.findAll();
        Car car = mapper.map(createCarDto, Car.class);
        Set<Part> setParts = new HashSet<>();
        int randomPartCount = 0;
        while(randomPartCount <= 10){
            randomPartCount = new Random().nextInt(20);
        }
        for (int i = 0; i < randomPartCount; i++) {
            int getRandomPart = new Random().nextInt(allParts.size());
            setParts.add(allParts.get(getRandomPart));
        }
        car.setParts(setParts);
        this.carRepository.saveAndFlush(car);
    }

    @Override
    public void createAllCars(List<CreateCarDto> createCarDtos) {
        for (CreateCarDto createCarDto : createCarDtos) {
            this.createCar(createCarDto);
        }
    }

    @Override
    public List<FindByMakerCarDto> findCarsByMaker(String maker) {
        return this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc(maker).stream()
                .map(car -> mapper.map(car, FindByMakerCarDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CarsPartListDto> getCarsAndTheirParts() {

        return this.carRepository.findAll().stream()
                .map(car -> mapper.map(car, CarsPartListDto.class))
                .collect(Collectors.toList());
    }
}
