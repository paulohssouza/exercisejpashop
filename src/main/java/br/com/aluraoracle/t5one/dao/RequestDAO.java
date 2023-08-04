package br.com.aluraoracle.t5one.dao;

import br.com.aluraoracle.t5one.model.Request;
import br.com.aluraoracle.t5one.vo.SalesReportVo;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class RequestDAO {
    private final EntityManager entityManager;

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

    public Request searchRequestWithCustomer(Long id) {
        String jpql = "select r from Request r join fetch r.customer where r.id = :id";
        return entityManager.createQuery(jpql, Request.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<SalesReportVo> generateSalesReport() {
        String jpql = "select new br.com.aluraoracle.t5one.vo.SalesReportVo(" +
                "product.name, sum(itemOrdered.quantity), " +
                "max(request.date)) from Request request join " +
                "request.itemOrderedList itemOrdered join " +
                "itemOrdered.product product group by product.name " +
                "order by itemOrdered.quantity desc";
        return entityManager.createQuery(jpql, SalesReportVo.class)
        .getResultList();
    }
}
