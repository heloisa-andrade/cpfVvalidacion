package com.example.desafio2.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "desafio")
public class Desafio2Model {
    @Id
    private String cpf;

    public Desafio2Model(String cpf) {
        this.cpf = cpf;
    }

    public Desafio2Model() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
