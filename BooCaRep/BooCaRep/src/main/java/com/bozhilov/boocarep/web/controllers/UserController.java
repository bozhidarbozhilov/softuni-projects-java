package com.bozhilov.boocarep.web.controllers;

import com.bozhilov.boocarep.domain.models.binding.person.PersonLoginBindingModel;
import com.bozhilov.boocarep.domain.models.binding.person.UserRegisterBindingModel;
import com.bozhilov.boocarep.domain.models.service.UserServiceModel;
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
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @Autowired
    public UserController(UserService userService, ModelMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(@ModelAttribute(name="userBinding")
                                                    UserRegisterBindingModel userRegisterBindingModel,
                                        ModelAndView modelAndView){
        modelAndView.setViewName("user-register");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@Valid @ModelAttribute(name="userBinding")
                                                 UserRegisterBindingModel userRegisterBindingModel,
                                     BindingResult result, ModelAndView modelAndView) throws InvalidObjectException {
        if(result.hasErrors()){
            modelAndView.setViewName("user-register");
        }else{
            UserServiceModel userServiceModel = this.mapper.map(userRegisterBindingModel, UserServiceModel.class);
            this.userService.saveUser(userServiceModel);

            modelAndView.setViewName("redirect:/users/login");
        }

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(@ModelAttribute(name="loginBindingModel")
                                             PersonLoginBindingModel personLoginBindingModel,
                                     ModelAndView modelAndView){
        modelAndView.setViewName("user-login");
        return modelAndView;
    }


}
