package repositories;

import java.util.List;

public interface GenericRepository<E, K> {
    List<E> getAll();
    E findById(K id);
    void saveEntity(E entity);
}
