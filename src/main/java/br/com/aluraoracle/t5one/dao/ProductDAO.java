package br.com.aluraoracle.t5one.dao;

import br.com.aluraoracle.t5one.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.math.BigDecimal;
import java.time.LocalDate;
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

    public List<Product> searchWithParameters(String name, BigDecimal price, LocalDate date) {
        String jpql = "select p from Product p where 1=1";
        if(name != null && name.isEmpty()) jpql += " and p.name = :name";

        if(price != null) jpql += " and p.price = :price";

        if(date != null) jpql += " and p.dateInsert = :date";


        TypedQuery<Product> typedQuery = entityManager.createQuery(jpql, Product.class);
        if(name != null && name.isEmpty()) typedQuery.setParameter("name", name);

        if(price != null) typedQuery.setParameter("price", price);

        if(date != null) typedQuery.setParameter("date", date);

        return typedQuery.getResultList();
    }

    public List<Product> searchWithCriteria(String name, BigDecimal price, LocalDate date) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        Predicate predicate = criteriaBuilder.and();
        if(name != null && !name.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("name"), name));
        }

        if(price != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("price"), price));
        }

        if(date != null) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("date"), date));
        };
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
