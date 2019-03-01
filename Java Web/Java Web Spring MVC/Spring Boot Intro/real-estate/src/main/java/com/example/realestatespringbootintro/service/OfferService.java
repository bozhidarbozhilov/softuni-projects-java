package com.example.realestatespringbootintro.service;

import com.example.realestatespringbootintro.domain.models.service.OfferServiceModel;

import java.util.List;

public interface OfferService {

    void registerOffer(OfferServiceModel offerServiceModel);

    List<OfferServiceModel> getAllOffers();

    void removeOffer(OfferServiceModel offerServiceModel);
}
