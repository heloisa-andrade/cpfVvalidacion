package com.example.wireMock._desafio.controller;

import com.example.wireMock._desafio.model.CpfModel;
import com.example.wireMock._desafio.repositroy.CpfRep;
import com.example.wireMock._desafio.service.Testeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DesafioController {
    @Autowired
    CpfRep cpfRep ;

    @Autowired
    Testeservice cpfService;
    @PostMapping("/desafio2")
    public ResponseEntity<Object> salvar(@RequestBody CpfModel cpfModel) {
        return cpfService.valisdar(cpfModel,cpfRep);
    }

}
