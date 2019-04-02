package thymeleafcontrollers.service;

import thymeleafcontrollers.domain.models.service.VirusServiceModel;

import java.util.List;

public interface VirusService {
    VirusServiceModel addVirus(VirusServiceModel virusServiceModel);

    List<VirusServiceModel> allViruses();

    VirusServiceModel findVirusById(String id);

    void deleteVirus(String id);

    VirusServiceModel editVirus(VirusServiceModel virusServiceModel);
}
