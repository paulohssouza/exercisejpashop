package br.com.aluraoracle.t5one.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbcustomers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private PersonalData personalData;

    public Customer() {
    }

    public Customer(String name, String cpf) {
        personalData = new PersonalData(name, cpf);
    }

    public String getName() {
        return this.personalData.getName();
    }

    public String getCpf() {
        return this.personalData.getCpf();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "\nCliente: " +
                "\nID= " + id +
                "\n" + personalData +
                "\n------------------------------------------";
    }
}
