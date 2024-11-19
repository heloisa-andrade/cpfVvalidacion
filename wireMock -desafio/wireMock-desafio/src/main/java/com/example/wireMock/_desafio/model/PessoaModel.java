package com.example.wireMock._desafio.model;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PessoaModel {
    private String name;
    private String job ;
    private String rg;
    private String cep;
    private Date birth_date;

}
