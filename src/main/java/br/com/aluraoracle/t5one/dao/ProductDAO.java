package br.com.aluraoracle.t5one.dao;

import br.com.aluraoracle.t5one.model.Product;
import jakarta.persistence.EntityManager;

public class ProductDAO {
    private EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Product product) {
        this.entityManager.persist(product);
    }
}
