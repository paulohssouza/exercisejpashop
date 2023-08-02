package br.com.aluraoracle.t5one.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbrequest")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "total_value")
    private BigDecimal totalValue;
    private LocalDate date;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    private List<ItemOrdered> itemOrderedList;

    public Request() {
    }

    public Request(Customer customer) {
        this.totalValue = BigDecimal.valueOf(0);
        this.date = LocalDate.now();
        this.customer = customer;
        itemOrderedList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ItemOrdered> getItemOrderedList() {
        return itemOrderedList;
    }

    public void setItemOrderedList(List<ItemOrdered> itemOrderedList) {
        this.itemOrderedList = itemOrderedList;
    }

    @Override
    public String toString() {
        return "\nPedido:" +
                "\nID= " + id +
                "\nValor Total= " + totalValue +
                "\nData= " + date +
                customer +
                "\n" + itemOrderedList +
                "\n-------------------------------------";
    }

    public void addItem(ItemOrdered itemOrdered) {
        itemOrdered.setRequest(this);
        this.itemOrderedList.add(itemOrdered);
        this.totalValue = this.totalValue.add(
                itemOrdered.getUnitPrice().multiply(
                        new BigDecimal(itemOrdered.getQuantity()))
        );
    }
}
