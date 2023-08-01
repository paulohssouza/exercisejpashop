package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.dao.CategoryDAO;
import br.com.aluraoracle.t5one.dao.ProductDAO;
import br.com.aluraoracle.t5one.model.Category;
import br.com.aluraoracle.t5one.model.Product;
import br.com.aluraoracle.t5one.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;

public class ProductRegistrationTest {
    public static void main(String[] args) {
        insertProduct();
        Integer id = 1;
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDAO productDAO = new ProductDAO(entityManager);
        System.out.println(productDAO.search());
    }

    private static void insertProduct() {
        Category smartphones = new Category("SMARTPHONES");
        Product product = new Product("Xiaomi Redmi",
                "Aparelho Redmi 12 novo lançamento da Xiaomi.",
                new BigDecimal("1500.00"),
                smartphones);

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDAO categoryDAO = new CategoryDAO(entityManager);
        ProductDAO productDAO = new ProductDAO(entityManager);

        entityManager.getTransaction().begin();
        categoryDAO.insert(smartphones);
        productDAO.insert(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}