package metube_v2.repository;

import metube_v2.domain.entities.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManager entityManager;

    @Inject
    public UserRepositoryImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    public User findByUsername(String username) {
        User foundUser;
        this.entityManager.clear();
        this.entityManager.getTransaction().begin();
        try{
            foundUser = this.entityManager
                    .createQuery("select u from User u where u.username=:username",User.class)
                    .setParameter("username", username).getSingleResult();
            return foundUser;
        }catch (Exception e){
            return null;
        }finally {
            this.entityManager.getTransaction().commit();
        }

    }

    @Override
    public User save(User entity) {
        this.entityManager.clear();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<User> getAll() {

        List<User> allUsers = this.entityManager
                .createQuery("select u from User u", User.class)
                .getResultList();
        return allUsers;
    }

    @Override
    public User findById(String id) {
        User foundUser;

        this.entityManager.clear();
        this.entityManager.getTransaction().begin();
        try{
            foundUser = this.entityManager
                    .createQuery("select u from User u where u.id=:id",User.class)
                    .setParameter("id", id).getSingleResult();
            return foundUser;
        }catch (Exception e){
            return null;
        }finally {
            this.entityManager.getTransaction().commit();
        }

    }

    @Override
    public User update(User entity) {
        this.entityManager.clear();
        this.entityManager.getTransaction().begin();
        User updatedUser = this.entityManager.merge(entity);
        this.entityManager.getTransaction().commit();
        return updatedUser;
    }
}
