package com.example.wireMock._desafio.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CepModel {
    private String CEP;
    private String logradouro;
    private String complento;
    private  String unidade;
    private String bairro;
    private  String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
