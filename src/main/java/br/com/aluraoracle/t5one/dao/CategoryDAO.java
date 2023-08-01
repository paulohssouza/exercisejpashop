package br.com.aluraoracle.t5one.dao;

import br.com.aluraoracle.t5one.model.Category;
import br.com.aluraoracle.t5one.model.Product;
import jakarta.persistence.EntityManager;

public class CategoryDAO {
    private final EntityManager entityManager;

    public CategoryDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Category category) {
        this.entityManager.persist(category);
    }

    public void update(Category category) {
        this.entityManager.merge(category);
    }
}
