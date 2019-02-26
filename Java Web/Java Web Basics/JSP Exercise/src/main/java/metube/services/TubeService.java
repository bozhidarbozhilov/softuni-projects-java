package services;

import metube.domain.models.TubeServiceModel;

import java.util.List;

public interface TubeService {
    void saveTube(TubeServiceModel tubeServiceModel);

    TubeServiceModel getTubeById(String id);

    TubeServiceModel getTubeByName(String name);

    List<TubeServiceModel> getAllTubes();
}
