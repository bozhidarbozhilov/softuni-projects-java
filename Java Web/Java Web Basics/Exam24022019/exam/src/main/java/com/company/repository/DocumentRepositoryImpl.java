package com.company.repository;

import com.company.domain.enitities.Document;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class DocumentRepositoryImpl implements DocumentRepository {
    private final EntityManager entityManager;

    @Inject
    public DocumentRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Document saveEntity(Document document) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(document);
            this.entityManager.getTransaction().commit();
        }catch (Exception e){
            this.entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }

        return document;
    }

    @Override
    public Document findById(String id) {
        return this.entityManager.createQuery("select d from Document d where d.id=:id",
                Document.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Document> findAll() {
        return this.entityManager
                .createQuery("select d from Document d", Document.class)
                .getResultList();
    }


    @Override
    public boolean print(String id) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.createQuery("delete from Document d where d.id=:id")
                    .setParameter("id", id).executeUpdate();
            this.entityManager.getTransaction().commit();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
