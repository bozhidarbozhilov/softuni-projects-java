package com.example.realestatespringbootintro.web.controllers;

import com.example.realestatespringbootintro.domain.models.binding.OfferFindBindingModel;
import com.example.realestatespringbootintro.domain.models.binding.OfferRegisterBindingModel;
import com.example.realestatespringbootintro.domain.models.service.OfferServiceModel;
import com.example.realestatespringbootintro.domain.models.view.OfferViewModel;
import com.example.realestatespringbootintro.service.OfferService;
import com.example.realestatespringbootintro.util.HtmlReader;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Validator;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OfferController {
    private final OfferService offerService;
    private final ModelMapper mapper;
    private final Validator validator;


    @Autowired
    public OfferController(OfferService offerService, ModelMapper mapper, Validator validator) {
        this.offerService = offerService;
        this.mapper = mapper;
        this.validator = validator;
    }

    @GetMapping("/reg")
    public String register(){
        return "/views/register.html";
    }


    @PostMapping("/reg")
    public String registerConfirm(@ModelAttribute OfferRegisterBindingModel offerRegisterBindingModel) {
        if(this.validator.validate(offerRegisterBindingModel).size()!=0){
            return "redirect:/reg";
        }

        OfferServiceModel offerServiceModel = this.mapper.map(offerRegisterBindingModel, OfferServiceModel.class);
        this.offerService.registerOffer(offerServiceModel);

        return "redirect:/";
    }

    @GetMapping("/find")
    public String find(){
        return "/views/find.html";
    }

    @PostMapping("/find")
    public String findOffer(@ModelAttribute OfferFindBindingModel findBindingModel){
        if(this.validator.validate(findBindingModel).size()>0){
            return "redirect:/find";
        }

        this.offerService.getAllOffers().stream()
                .filter(o -> o.getApartmentType().equalsIgnoreCase(findBindingModel.getFamilyApartmentType()) &&
                        findBindingModel.getFamilyBudget()
                                .compareTo(o.getApartmentRent()
                                        .add(o.getApartmentRent()
                                                .multiply(o.getAgencyCommission()
                                                        .divide(BigDecimal.valueOf(100L),
                                                                RoundingMode.CEILING)))) >= 0)
                .findFirst()
                .ifPresent(this.offerService::removeOffer);


        return "redirect:/";
    }
}
