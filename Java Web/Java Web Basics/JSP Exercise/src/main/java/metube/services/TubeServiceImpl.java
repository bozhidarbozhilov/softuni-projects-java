package services;

import metube.domain.entities.Tube;
import metube.domain.models.TubeServiceModel;
import metube.repositories.TubeRepository;
import metube.utils.ModelMapper;
import repositories.TubeRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class TubeServiceImpl implements TubeService {
    private final TubeRepository tubeRepository;
    private final ModelMapper modelMapper;

    @Inject
    public TubeServiceImpl(TubeRepository tubeRepository, ModelMapper modelMapper) {
        this.tubeRepository = tubeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveTube(TubeServiceModel tubeServiceModel) {
        Tube tube = modelMapper.map(tubeServiceModel, Tube.class);
        this.tubeRepository.saveEntity(tube);
    }

    @Override
    public TubeServiceModel getTubeById(String id) {
        Tube tubeById = this.tubeRepository.findById(id);

        return modelMapper.map(tubeById, TubeServiceModel.class);
    }

    @Override
    public TubeServiceModel getTubeByName(String name) {
        Tube tubeByName = this.tubeRepository.findById(name);

        return modelMapper.map(tubeByName, TubeServiceModel.class);
    }

    @Override
    public List<TubeServiceModel> getAllTubes() {
        List<Tube> tubes = this.tubeRepository.getAll();
        for (Tube tube : tubes) {
            
        }
        return this.tubeRepository.getAll()
                .stream().map(tube -> modelMapper.map(tube, TubeServiceModel.class))
                .collect(Collectors.toList());

    }
}
