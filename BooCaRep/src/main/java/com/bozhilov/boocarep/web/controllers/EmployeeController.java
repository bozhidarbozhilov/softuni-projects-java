package com.bozhilov.boocarep.web.controllers;

import com.bozhilov.boocarep.domain.models.binding.person.EmployeeRegistrationBindingModel;
import com.bozhilov.boocarep.domain.models.binding.person.PersonLoginBindingModel;
import com.bozhilov.boocarep.domain.models.service.EmployeeServiceModel;
import com.bozhilov.boocarep.service.employee.EmployeeService;
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
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ModelMapper mapper) {
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    @GetMapping("/register")
    public ModelAndView getEmployeeRegisterPage(
            @ModelAttribute(name="employeeBinding") EmployeeRegistrationBindingModel employeeBinding,
            ModelAndView modelAndView){
        modelAndView.setViewName("employee-register");

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerEmployee(@Valid @ModelAttribute(name="employeeBinding")
                                         EmployeeRegistrationBindingModel employeeRegistrationBindingModel,
                                         BindingResult bindingResult, ModelAndView modelAndView) throws InvalidObjectException {
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("employee-register");
        }else{
            EmployeeServiceModel employeeServiceModel =
                    this.mapper.map(employeeRegistrationBindingModel, EmployeeServiceModel.class);

            this.employeeService.saveEmployee(employeeServiceModel);

            modelAndView.setViewName("redirect:/employees/login");
        }

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage(@ModelAttribute(name="loginBindingModel")
                                     PersonLoginBindingModel personLoginBindingModel,
                                     ModelAndView modelAndView){
        modelAndView.setViewName("employee-login");
        return modelAndView;
    }
}
