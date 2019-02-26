package metube.repositories;

import metube.domain.entities.Tube;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

public class TubeRepositoryImpl implements TubeRepository {
    private EntityManager entityManager;

    @Inject
    public TubeRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("metube")
                .createEntityManager();
    }

    @Override
    public Optional<Tube> findByName(String name) {
        try{
            Optional<Tube> getByName = Optional.of(this.entityManager
                    .createQuery("select t from Tube t where t.name=:name", Tube.class)
                    .setParameter("name", name).getSingleResult());
            return getByName;
        }catch (NoResultException e){
            return Optional.empty();
        }


    }

    @Override
    public Tube saveEntity(Tube entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<Tube> getAll() {
        CriteriaQuery<Tube> criteriaQuery = this.entityManager
                .getCriteriaBuilder()
                .createQuery(Tube.class);

        criteriaQuery.from(Tube.class);

        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Tube getById(String id) {
        this.entityManager.getTransaction().begin();

        Tube getById = (Tube) this.entityManager
                .createQuery("select t from Tube t where t.id=:id", Tube.class)
                .setParameter("id", id);
        this.entityManager.getTransaction().commit();
        return getById;
    }
}
