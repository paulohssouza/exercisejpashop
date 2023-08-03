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
        Integer id = 1;
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDAO productDAO = new ProductDAO(entityManager);
        System.out.println(productDAO.searchById(1));
        System.out.println(productDAO.search());
        System.out.println(productDAO.searchByNameReturningPrice("Samsumg 360"));
        System.out.println(productDAO.searchByCategoryName("SMARTPHONES"));


    }

    private static void insertProduct() {
        Category smartphones = new Category("SMARTPHONES");
        Category books = new Category("BOOKS");
        Category computer = new Category("COMPUTER");
        Product xiaomiRedmi = new Product("Xiaomi Redmi",
                "Aparelho Redmi 12 novo lançamento da Xiaomi.",
                new BigDecimal("1500.00"),
                smartphones);
        Product notebook = new Product("Samsumg 360",
                "Notebook de última geração Samsumg",
                new BigDecimal("3750.99"),
                computer);
        Product senhordosaneis = new Product("O Senhor dos Anéis",
                "Edição de colecionador de O Senhor do Anéis",
                new BigDecimal("145.75"),
                books);
        Product galaxy = new Product("Samsumg Galaxy S",
                "Smartphone linha galaxy S Samsumg",
                new BigDecimal("5623.99"),
                smartphones);
        Product dellG15 = new Product("Dell G15",
                "Notebook Gamer Dell G15",
                new BigDecimal("6250.99"),
                computer);
        Product guiamochileiro = new Product("O Guia do Mochileiro das Galáxias",
                "Edição completa do Guia do Mochileiro das Galáxias.",
                new BigDecimal("75.99"),
                books);
        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoryDAO categoryDAO = new CategoryDAO(entityManager);
        ProductDAO productDAO = new ProductDAO(entityManager);

        entityManager.getTransaction().begin();
        categoryDAO.insert(smartphones);
        categoryDAO.insert(computer);
        categoryDAO.insert(books);
        productDAO.insert(xiaomiRedmi);
        productDAO.insert(notebook);
        productDAO.insert(senhordosaneis);
        productDAO.insert(galaxy);
        productDAO.insert(dellG15);
        productDAO.insert(guiamochileiro);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
