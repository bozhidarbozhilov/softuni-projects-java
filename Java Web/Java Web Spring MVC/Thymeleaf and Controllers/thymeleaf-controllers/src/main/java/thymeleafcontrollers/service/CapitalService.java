package thymeleafcontrollers.service;

import thymeleafcontrollers.domain.models.service.CapitalServiceModel;

import java.util.List;

public interface CapitalService {
    List<CapitalServiceModel> allCapitals();

    CapitalServiceModel findCapitalByName(String name);
}
