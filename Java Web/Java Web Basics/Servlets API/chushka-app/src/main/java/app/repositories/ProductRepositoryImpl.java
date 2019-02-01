package app.repositories;

import app.domain.entities.Product;
import app.domain.entities.Product_;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    private final EntityManager entityManager;

    public ProductRepositoryImpl() {
        this.entityManager= Persistence.createEntityManagerFactory("chushka")
                .createEntityManager();
    }

    @Override
    public void save(Product entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
    }

    @Override
    public Product findById(Long id) {
        CriteriaBuilder builder = this.entityManager
                .getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> productRoot = criteria.from(Product.class);
        criteria.select(productRoot);
        criteria.where(builder.equal(productRoot.get(Product_.ID), id));

        this.entityManager.getTransaction().begin();
        Product product = this.entityManager.createQuery(criteria).getSingleResult();
        this.entityManager.getTransaction().commit();
        return product;
    }

    @Override
    public List<Product> findAll() {
        CriteriaQuery<Product> criteriaQuery = this.entityManager
                .getCriteriaBuilder()
                .createQuery(Product.class);

        criteriaQuery.from(Product.class);

        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Product findByName(String name) {
        CriteriaBuilder builder = this.entityManager
                .getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> productRoot = criteria.from(Product.class);
        criteria.select(productRoot);
        criteria.where(builder.equal(productRoot.get(Product_.name), name));

        this.entityManager.getTransaction().begin();
        Product product = this.entityManager.createQuery(criteria).getSingleResult();
        this.entityManager.getTransaction().commit();
        return product;
    }
}
