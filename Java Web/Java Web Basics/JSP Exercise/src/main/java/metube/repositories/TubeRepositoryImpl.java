package repositories;

import metube.domain.entities.Tube;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TubeRepositoryImpl implements TubeRepository {
    private final EntityManager entityManager;

    public TubeRepositoryImpl() {
        this.entityManager = Persistence
                .createEntityManagerFactory("metube")
                .createEntityManager();
    }

    @Override
    public List<Tube> getAll() {
        CriteriaQuery<Tube> tubeCriteria = this.entityManager
                .getCriteriaBuilder()
                .createQuery(Tube.class);

        tubeCriteria.from(Tube.class);

        return this.entityManager.createQuery(tubeCriteria).getResultList();
    }

    @Override
    public Tube findById(String id) {
        Query getTubeById = this.entityManager.createQuery("select t from Tube t where t.id=:id", Tube.class)
                .setParameter("id",id);
        this.entityManager.getTransaction().begin();
        Tube tube = (Tube) getTubeById.getSingleResult();
        this.entityManager.getTransaction().commit();
        return tube;
    }

    @Override
    public Tube findByName(String name) {
        Query getTubeById = this.entityManager.createQuery("select t from Tube t where t.name=:name", Tube.class)
                .setParameter("name",name);
        this.entityManager.getTransaction().begin();
        Tube tube = (Tube) getTubeById.getSingleResult();
        this.entityManager.getTransaction().commit();
        return tube;
    }

    @Override
    public void saveEntity(Tube entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
    }
}
