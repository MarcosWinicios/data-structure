package com.studies.algorithms.sorting.service;

import com.studies.algorithms.sorting.model.Result;
import com.studies.config.ConnectionDatabase;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ResultService {

    private final EntityManager entityManager;

    public ResultService() {
        this.entityManager = ConnectionDatabase.getInstance().getConnection().createEntityManager();
    }

    public Result save(Result result) {
        entityManager.getTransaction().begin();
        result = this.entityManager.merge(result);
        entityManager.getTransaction().commit();
        return result;
    }

    public List<Result> findByGroupId(String groupId) {
        return entityManager.createQuery("from Result", Result.class).getResultList();
    }

}
