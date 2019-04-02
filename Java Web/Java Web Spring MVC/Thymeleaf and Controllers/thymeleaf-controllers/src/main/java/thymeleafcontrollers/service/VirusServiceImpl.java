package thymeleafcontrollers.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thymeleafcontrollers.domain.entities.Capital;
import thymeleafcontrollers.domain.entities.Virus;
import thymeleafcontrollers.domain.models.service.CapitalServiceModel;
import thymeleafcontrollers.domain.models.service.VirusServiceModel;
import thymeleafcontrollers.repository.CapitalRepository;
import thymeleafcontrollers.repository.VirusRepository;
import thymeleafcontrollers.utility.constants.Constants;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class VirusServiceImpl implements VirusService {
    private final VirusRepository virusRepository;
    private final CapitalRepository capitalRepository;
    private final ModelMapper mapper;
    private final Validator validator;

    @Autowired
    public VirusServiceImpl(VirusRepository virusRepository, CapitalRepository capitalRepository, ModelMapper mapper, Validator validator) {
        this.virusRepository = virusRepository;
        this.capitalRepository = capitalRepository;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public VirusServiceModel addVirus(VirusServiceModel virusServiceModel) {
        Set<ConstraintViolation<VirusServiceModel>> validators = validator.validate(virusServiceModel);
        if(validators.size()>0){
            throw new IllegalArgumentException(Constants.INVALID_INPUT_DATA_MESSAGE);
        }
        Virus virus = mapper.map(virusServiceModel, Virus.class);
        virus.setCapitals(virusServiceModel.getCapitals().stream()
                            .map(this.capitalRepository::findByName)
                            .collect(Collectors.toSet()));
        Virus savedVirus = this.virusRepository.save(virus);

        return this.mapper.map(savedVirus, VirusServiceModel.class);
    }

    @Override
    public List<VirusServiceModel> allViruses() {
        List<Virus> viruses = this.virusRepository.findAll();
        List<VirusServiceModel> virusList = viruses.stream()
                .map(virus -> this.mapper.map(virus, VirusServiceModel.class))
                .collect(Collectors.toList());
        return virusList;
    }

    @Override
    public VirusServiceModel findVirusById(String id) {
        Virus virus = this.virusRepository.findById(id).orElse(null);

        if(virus!=null){
            VirusServiceModel virusServiceModel = this.mapper.map(virus, VirusServiceModel.class);
            virusServiceModel.setCapitals(virus.getCapitals().stream()
                    .map(Capital::getName).collect(Collectors.toSet()));
            return virusServiceModel;
        }
        return null;
    }

    @Override
    public void deleteVirus(String id) {
        this.virusRepository.deleteById(id);
    }

    @Override
    public VirusServiceModel editVirus(VirusServiceModel virusServiceModel) {
        Virus virusForEdit = this.mapper.map(virusServiceModel, Virus.class);
        virusForEdit.setCapitals(virusServiceModel.getCapitals()
        .stream().map(this.capitalRepository::findByName).collect(Collectors.toSet()));
        Virus editedVirus = this.virusRepository.save(virusForEdit);
        return this.mapper.map(editedVirus, VirusServiceModel.class);

    }


}
