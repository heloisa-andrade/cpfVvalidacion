package com.example.testemongo.controller;

import com.example.testemongo.Repositroy.CpfRep;
import com.example.testemongo.model.Cpfmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CpfController {
    @Autowired
    CpfRep cpfRep;
    @PostMapping("/teste")
    public void addcpf (@RequestBody Cpfmodel cpfmodel){
        cpfRep.save(cpfmodel);
    }
//
    public ResponseEntity<Objects> getOneProducts (@PathVariable(value = "id") Integer id){
        Optional<Cpfmodel> cpf0 = cpfRep.findById(id);
        if (cpf0.isEmpty()){
            return ResponseEntity.status((HttpStatus.NOT_FOUND)).body("Não encontrado");
        }
    }
//@GetMapping("/products/{id}")
//public ResponseEntity<Object> getOneProducts(@PathVariable(value = "id") UUID id){
//    Optional<ProductModel> product0 =  productRepository.findById(id);
//    if (product0.isEmpty()){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
//    }
//    product0.get().add(linkTo(methodOn(ProductController.class).getAllProducts()).withSelfRel());
//    return ResponseEntity.status(HttpStatus.OK).body(product0.get());
//}
}
