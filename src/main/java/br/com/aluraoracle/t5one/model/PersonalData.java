package br.com.aluraoracle.t5one.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PersonalData {
    private String name;
    @Column(length = 11)
    private String cpf;

    public PersonalData() {
    }

    public PersonalData(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "name=' " + name + '\'' +
               "\ncpf=' " + cpf + '\'';
    }
}
