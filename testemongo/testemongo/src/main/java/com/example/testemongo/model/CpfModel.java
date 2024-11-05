package com.example.testemongo.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection= "desafio")
@NoArgsConstructor
@AllArgsConstructor
public class CpfModel {
    @Id
    private String cpf;
    private Boolean isValidacion;
    public CpfModel(String cpf) {
        this.cpf = cpf;
    }
}
