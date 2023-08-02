package br.com.aluraoracle.t5one.dao;

import br.com.aluraoracle.t5one.model.Request;
import jakarta.persistence.EntityManager;

public class RequestDAO {
    private EntityManager entityManager;

    public RequestDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Request request) {
        this.entityManager.persist(request);
    }
}
