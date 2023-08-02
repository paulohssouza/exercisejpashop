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
}
