package metube.services;

import metube.domain.entities.Tube;
import metube.domain.models.TubeServiceModel;

import java.util.List;
import java.util.Optional;

public interface TubeService {
    void saveTube(TubeServiceModel tube);
    TubeServiceModel getTubeById(String id);
    TubeServiceModel getTubeByName(String name);
    List<TubeServiceModel> getAllTubes();
}
