package br.com.aluraoracle.t5one.dao;

import br.com.aluraoracle.t5one.model.Product;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class ProductDAO {
    private final EntityManager entityManager;

    public ProductDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Product product) {
        this.entityManager.persist(product);
    }

    public Product searchById(Integer id) {
        return this.entityManager.find(Product.class, id);
    }

    public List<Product> search() {
        String jpql = "SELECT p FROM Product AS p";
        return this.entityManager.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> searchByName(String name) {
        String jpql = "select p from Product p where p.name = :name";
        return this.entityManager.createQuery(jpql, Product.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<Product> searchByCategoryName(String categoryName) {
        return this.entityManager.createNamedQuery("Product.productForCategory", Product.class)
                .setParameter("categoryName", categoryName)
                .getResultList();
    }

    public BigDecimal searchByNameReturningPrice(String name) {
        String jpql = "select p.price from Product p where p.name = :name";
        return this.entityManager.createQuery(jpql, BigDecimal.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
