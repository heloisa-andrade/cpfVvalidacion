package com.example.testemongo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Document(collation = "desafio")
public class Cpfmodel extends RepresentationModel<Cpfmodel> implements Serializable {
    @Id
    private String cpf;
    private Boolean isValidacion;

    public String getCpf() {
        return cpf;
    }


    public Boolean getValidacion() {
        return isValidacion;
    }

    public void setValidacion(Boolean validacion) {
        isValidacion = validacion;
    }

    public Cpfmodel(String cpf, Boolean isValidacion) {
        this.cpf = cpf;
        this.isValidacion = isValidacion;
    }


}
