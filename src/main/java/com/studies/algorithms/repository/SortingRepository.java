package com.studies.algorithms.repository;

import com.studies.algorithms.metrics.ResultSorting;
import com.studies.config.ConnectionDatabase;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SortingRepository {

    private final EntityManager entityManager;

    public SortingRepository() {
        this.entityManager = ConnectionDatabase.getInstance().getConnection().createEntityManager();
    }

    public ResultSorting save(ResultSorting result) {
        entityManager.getTransaction().begin();
        result = this.entityManager.merge(result);
        entityManager.getTransaction().commit();
        return result;
    }

    public List<ResultSorting> findByGroupId(String groupId) {
        return entityManager.createQuery("from ResultSorting", ResultSorting.class).getResultList();
    }

}
