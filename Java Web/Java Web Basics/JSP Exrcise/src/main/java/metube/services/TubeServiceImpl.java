package metube.services;

import metube.domain.entities.Tube;
import metube.domain.models.TubeServiceModel;
import metube.repositories.TubeRepository;
import metube.util.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TubeServiceImpl implements TubeService {
    private final TubeRepository repository;
    private final ModelMapper modelMapper;

    @Inject
    public TubeServiceImpl(TubeRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveTube(TubeServiceModel tubeModel) {
        Tube tube = this.modelMapper.map(tubeModel, Tube.class);
        this.repository.saveEntity(tube);
    }

    @Override
    public TubeServiceModel getTubeById(String id) {
        TubeServiceModel tubeModel = this.modelMapper.map(this.repository.getById(id),
                TubeServiceModel.class);
        return tubeModel;
    }

    @Override
    public TubeServiceModel getTubeByName(String name) {
        Tube foundTube = this.repository.findByName(name).orElse(null);
        if(foundTube!=null){
            return this.modelMapper.map(foundTube,
                    TubeServiceModel.class);
        }

        return null;
    }

    @Override
    public List<TubeServiceModel> getAllTubes() {

        return this.repository.getAll().stream()
                .map(tube-> this.modelMapper.map(tube, TubeServiceModel.class))
                .collect(Collectors.toList());
    }
}
