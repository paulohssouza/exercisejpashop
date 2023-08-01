package br.com.aluraoracle.t5one.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tbitem_ordered")
public class ItemOrdered {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal unitPrice;
    private Integer quantity;
    @ManyToOne
    private Request request;
    @ManyToOne
    private Product product;

    public ItemOrdered() {
    }

    public ItemOrdered(Integer quantity, Request request, Product product) {
        this.unitPrice = product.getPrice();
        this.quantity = quantity;
        this.request = request;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "\nItens Pedidos{" +
                "\nid= " + id +
                "\nPreço unitário= " + unitPrice +
                "\nQuantidade=" + quantity +
                "\n-----------------------------------------";
    }


}
