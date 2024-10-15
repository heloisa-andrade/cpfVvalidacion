package com.example.testemongo.controller;

import com.example.testemongo.Repositroy.CpfRep;
import com.example.testemongo.model.Cpfmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class CpfController {
    @Autowired
    CpfRep cpfRep;
    @PostMapping("/teste")
    public void addcpf (@RequestBody Cpfmodel cpfmodel){
        cpfRep.save(cpfmodel);
    }
    @GetMapping("/cpf") // mostra todos os registos
    public ResponseEntity<List<Cpfmodel>> getAllProducts(){
        List<Cpfmodel> productsList = cpfRep.findAll();
        if(!productsList.isEmpty() ){
            for (Cpfmodel cpfmodel : productsList){
               String id = cpfmodel.getCpf();
                cpfmodel.add(linkTo(methodOn(CpfController.class).getAllProducts()).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(productsList);
    }


}
