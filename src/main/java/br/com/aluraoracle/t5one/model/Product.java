package br.com.aluraoracle.t5one.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tbproduct")
@NamedQuery(name = "Product.productForCategory",
        query = "select p from Product p where p.category.name = :categoryName")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(length = 600)
    private String description;
    private BigDecimal price;
    @Column(name = "date_insert")
    private LocalDate dateInsert;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.dateInsert = LocalDate.now();
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(LocalDate dateInsert) {
        this.dateInsert = dateInsert;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return  "\nID= " + id +
                "\nNome= '" + name + '\'' +
                "\nDescrição= '" + description + '\'' +
                "\nPreço= " + price +
                "\nData inlcusão= " + dateInsert +
                "\nCategoria= " + category.getName() +
                "\n----------------------------------------";
    }
}
