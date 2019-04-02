package thymeleafcontrollers.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thymeleafcontrollers.domain.models.service.CapitalServiceModel;
import thymeleafcontrollers.repository.CapitalRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CapitalServiceImpl implements CapitalService {

    private final CapitalRepository capitalRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CapitalServiceImpl(CapitalRepository capitalRepository, ModelMapper modelMapper) {
        this.capitalRepository = capitalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CapitalServiceModel> allCapitals() {
        return this.capitalRepository.findAll().stream()
                .map(capital -> this.modelMapper.map(capital, CapitalServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CapitalServiceModel findCapitalByName(String name) {
        return this.modelMapper.map(this.capitalRepository.findByName(name),CapitalServiceModel.class);
    }
}
