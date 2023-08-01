package br.com.aluraoracle.t5one.dao;

import br.com.aluraoracle.t5one.model.Product;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductDAO {
    private final EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Product product) {
        this.entityManager.persist(product);
    }

    public Product searchId(Integer id) {
        return entityManager.find(Product.class, id);
    }

    public List<Product> search() {
        String jpql = "SELECT p FROM Product AS p";
        return entityManager.createQuery(jpql, Product.class).getResultList();
    }
}
