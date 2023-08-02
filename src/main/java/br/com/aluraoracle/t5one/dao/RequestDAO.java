package br.com.aluraoracle.t5one.dao;

import br.com.aluraoracle.t5one.model.Request;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class RequestDAO {
    private EntityManager entityManager;

    public RequestDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Request request) {
        this.entityManager.persist(request);
    }

    public BigDecimal totalValueSold() {
        String jpql = "select sum(p.totalValue) from Request p";
        return this.entityManager.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<Object[]> generateSalesReport() {
        String jpql = "select product.name, sum(itemOrdered.quantity), " +
                "max(request.date) from Request request join " +
                "request.itemOrderedList itemOrdered join " +
                "itemOrdered.product product group by product.name";
        return entityManager.createQuery(jpql, Object[].class)
        .getResultList();
    }
}
