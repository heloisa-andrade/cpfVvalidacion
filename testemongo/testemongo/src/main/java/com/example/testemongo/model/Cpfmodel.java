package com.example.testemongo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collation = "desafio")
@Getter
@Setter
@AllArgsConstructor
public class Cpfmodel {
    @Id
    private Integer id;
    private String cpf;
    private Boolean isValidacion;
    public Cpfmodel(String cpf,boolean isValidacion ){
        this.cpf = cpf;
        this.isValidacion = isValidacion;
    }
    public Cpfmodel(){}

}
