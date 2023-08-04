package br.com.aluraoracle.t5one.dao;

import br.com.aluraoracle.t5one.model.Customer;
import jakarta.persistence.EntityManager;

public class CustomerDAO {
    private EntityManager entityManager;

    public CustomerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Customer customer) {
        this.entityManager.persist(customer);
    }

    public Customer searchById(int id) {
        String jpql = "select c from Customer c where c.id = :id";
        return entityManager.createQuery(jpql, Customer.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
