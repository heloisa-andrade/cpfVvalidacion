package com.example.wireMock._desafio.repositroy;

import com.example.wireMock._desafio.model.CepModel;
import com.example.wireMock._desafio.model.PessoaModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "pessoa-consumer",url = "http://localhost:8081")
public interface PessoaRep {
    @GetMapping(value = "/info?cpf={pessoa}")
    PessoaModel getPessoa(@PathVariable("pessoa") String id);
}
