package br.com.aluraoracle.t5one;

import br.com.aluraoracle.t5one.dao.CategoryDAO;
import br.com.aluraoracle.t5one.dao.ProductDAO;
import br.com.aluraoracle.t5one.model.Category;
import br.com.aluraoracle.t5one.model.Product;
import br.com.aluraoracle.t5one.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class PopulatesProducts {
    public static void main(String[] args) {
        Category smartphones = new Category("SMARTPHONES");
        Category computer = new Category("COMPUTER");
        Category book = new Category("BOOK");
        Category appliances = new Category("APPLIANCES");
        Product xiaomi = new Product("Xiaomi Redmi 12",
                "Novo lançamento Xiaomi com os recursos mais avançados",
                new BigDecimal("1457.99"), smartphones);
        Product galaxy = new Product("Galaxy Note 12",
                "Novo lançamento Samsumg com os recursos mais avançados",
                new BigDecimal("4385.99"), smartphones);
        Product iphone = new Product("Iphone 14",
                "Novo lançamento Apple com os recursos mais avançados",
                new BigDecimal("8538.99"), smartphones);
        Product motog = new Product("Moto G14",
                "Novo lançamento Motorola com os recursos mais avançados",
                new BigDecimal("1538.99"), smartphones);
        Product macbook = new Product("MacBook Pro",
                "Novo lançamento Apple com os recursos mais avançados",
                new BigDecimal("14538.99"), computer);
        Product galaxy360 = new Product("Samsumg Galaxy 360",
                "Novo lançamento Samsumg com os recursos mais avançados",
                new BigDecimal("63538.99"), computer);
        Product notebookDell = new Product("NoteBook Dell G15",
                "Novo lançamento Dell com os recursos mais avançados",
                new BigDecimal("62538.99"), computer);
        Product notebookPositivo = new Product("NoteBook Positivo",
                "Novo lançamento Positivo com os recursos mais avançados",
                new BigDecimal("38538.99"), computer);
        Product guiaMochileiro = new Product("O guia do mochileiro das galáxias",
                "Edição completa desta aventura pelo espaço sensacional!",
                new BigDecimal("75.99"), book);
        Product senhorDosAneis = new Product("O Senhor dos Anéis",
                "Edição completa desta aventura pela terra média!",
                new BigDecimal("90.99"), book);
        Product theWitcher = new Product("The Witcher",
                "As aventuras de Geralt de Rivia, o bruxo dos bruxos!",
                new BigDecimal("83.99"), book);
        Product harryPotter = new Product("Harry Potter",
                "Edição completa desta aventura em hogwarts!",
                new BigDecimal("155.99"), book);
        Product liquidificador = new Product("Liquidificador Osten",
                "Liquidificador Osten com 7 velocidades.",
                new BigDecimal("157.99"), appliances);
        Product batedeira = new Product("Batedeira Planetária Arno",
                "Batedeira planetária arno, com várias velocidades.",
                new BigDecimal("358.99"), appliances);
        Product multiProcessador = new Product("MultiProcessador Arno",
                "MultiProcessador Arno multifunção.",
                new BigDecimal("287.99"), appliances);
        Product fogaoConsul = new Product("Fogão Consul",
                "Fogão de última geração Consul.",
                new BigDecimal("487.99"), appliances);
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProductDAO productDAO = new ProductDAO(entityManager);
        CategoryDAO categoryDAO = new CategoryDAO(entityManager);

        entityManager.getTransaction().begin();

        categoryDAO.insert(smartphones);
        categoryDAO.insert(computer);
        categoryDAO.insert(book);
        categoryDAO.insert(appliances);

        productDAO.insert(xiaomi);
        productDAO.insert(galaxy);
        productDAO.insert(iphone);
        productDAO.insert(motog);
        productDAO.insert(galaxy360);
        productDAO.insert(macbook);
        productDAO.insert(notebookDell);
        productDAO.insert(notebookPositivo);
        productDAO.insert(guiaMochileiro);
        productDAO.insert(senhorDosAneis);
        productDAO.insert(theWitcher);
        productDAO.insert(harryPotter);
        productDAO.insert(liquidificador);
        productDAO.insert(batedeira);
        productDAO.insert(multiProcessador);
        productDAO.insert(fogaoConsul);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
