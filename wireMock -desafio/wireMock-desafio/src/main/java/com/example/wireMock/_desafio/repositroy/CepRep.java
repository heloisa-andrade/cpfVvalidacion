package com.example.wireMock._desafio.repositroy;

import com.example.wireMock._desafio.model.CepModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cep-consumer",url = "http://viacep.com.br")
public interface CepRep {
    @GetMapping(value = "/ws/{cep}/json")
    CepModel getCep(@PathVariable("cep") String id);
}
