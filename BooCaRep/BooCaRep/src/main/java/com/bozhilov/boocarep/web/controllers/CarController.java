package com.bozhilov.boocarep.web.controllers;

import com.bozhilov.boocarep.domain.entities.users.User;
import com.bozhilov.boocarep.domain.models.binding.tech.CarCreateBindingModel;
import com.bozhilov.boocarep.domain.models.service.CarServiceModel;
import com.bozhilov.boocarep.service.car.CarService;
import com.bozhilov.boocarep.service.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.InvalidObjectException;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public CarController(CarService carService, ModelMapper modelMapper, UserService userService) {
        this.carService = carService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/create")
    public ModelAndView getCarCreatePage(@ModelAttribute(name="carCreateBinding")CarCreateBindingModel
                                         carCreateBindingModel, ModelAndView modelAndView){
        modelAndView.setViewName("car-create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createCar(@Valid @ModelAttribute(name="carCreateBinding")CarCreateBindingModel
                                                 carCreateBindingModel, BindingResult result,
                                                        ModelAndView modelAndView) throws InvalidObjectException {
        if(result.hasErrors()){
            modelAndView.setViewName("car-create");
        }else{
            CarServiceModel carServiceModel = this.modelMapper.map(carCreateBindingModel,
                    CarServiceModel.class);
            //TODO: set car owner
            carServiceModel.setOwner(this.userService.findAllUsers().get(0));
            this.carService.saveCar(carServiceModel);
            modelAndView.setViewName("redirect:/home");
        }

        return modelAndView;
    }
}
