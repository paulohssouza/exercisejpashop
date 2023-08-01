package br.com.aluraoracle.t5one.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbcustomers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(length = 11)
    private String cpf;

    public Customer() {
    }

    public Customer(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return  "\nCliente: " +
                "\nID= " + id +
                "\nNome= '" + name + '\'' +
                "\nCPF= '" + cpf + '\'' +
                "\n------------------------------------------";
    }
}
