package com.example.realestatespringbootintro.service;

import com.example.realestatespringbootintro.domain.entities.Offer;
import com.example.realestatespringbootintro.domain.models.service.OfferServiceModel;
import com.example.realestatespringbootintro.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final Validator validator;
    private final ModelMapper mapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, Validator validator, ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public void registerOffer(OfferServiceModel offerServiceModel) {
        if(this.validator.validate(offerServiceModel).size()!=0) {
            throw new IllegalArgumentException("Can not persist object!");
        }
        this.offerRepository.saveAndFlush(this.mapper.map(offerServiceModel, Offer.class));
    }

    @Override
    public List<OfferServiceModel> getAllOffers() {
        return this.offerRepository.findAll().stream()
                .map(o->this.mapper.map(o, OfferServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void removeOffer(OfferServiceModel offerServiceModel) {
        this.offerRepository.delete(this.mapper.map(offerServiceModel, Offer.class));
    }
}
