package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.dao.ProductDAO;
import br.com.aluraoracle.t5one.model.Category;
import br.com.aluraoracle.t5one.model.Product;
import br.com.aluraoracle.t5one.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistrationTest {
    public static void main(String[] args) {
        Product product = new Product("Xiaomi Redmi",
                "Aparelho Redmi 12 novo lançamento da Xiaomi.",
                new BigDecimal("1500.00"),
                Category.SMARTPHONES);

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDAO productDAO = new ProductDAO(entityManager);

        entityManager.getTransaction().begin();
        productDAO.insert(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
