package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class ProductRegistrationTest {
    public static void main(String[] args) {
        Product product = new Product();
        product.setName("Xiaomi Redmi");
        product.setDescription("Aparelho Redmi 12 nova lançamento da Xiaomi.");
        product.setPrice(new BigDecimal("1500.00"));

        try(EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("exercisejpashop")) {

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(product);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }
}
