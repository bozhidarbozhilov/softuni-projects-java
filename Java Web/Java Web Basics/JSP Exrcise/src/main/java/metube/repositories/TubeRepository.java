package metube.repositories;

import metube.domain.entities.Tube;

import java.util.Optional;

public interface TubeRepository extends GenericRepository<Tube, String> {
    Optional<Tube> findByName(String name);
}
