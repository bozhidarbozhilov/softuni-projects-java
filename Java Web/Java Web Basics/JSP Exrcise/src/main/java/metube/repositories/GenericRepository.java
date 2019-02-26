package metube.repositories;

import java.util.List;

public interface GenericRepository<E, K> {
    E saveEntity(E entity);
    List<E> getAll();
    E getById(K id);
}
