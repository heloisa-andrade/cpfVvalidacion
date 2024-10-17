package com.example.testemongo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;

@Document(collection= "desafio")
public class Cpfmodel {
    @Id
    private String cpf;

    public Cpfmodel(String cpf) {
        this.cpf = cpf;
    }

    public Cpfmodel() {
    }

    public String getCpf() {
        return cpf;
    }
}
