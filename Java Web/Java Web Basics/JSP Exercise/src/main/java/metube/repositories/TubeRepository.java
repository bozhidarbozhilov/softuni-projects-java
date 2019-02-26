package repositories;

import metube.domain.entities.Tube;

public interface TubeRepository extends GenericRepository<Tube, String>  {

    Tube findByName(String name);
}
