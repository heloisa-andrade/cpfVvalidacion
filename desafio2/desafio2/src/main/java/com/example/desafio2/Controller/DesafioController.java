package com.example.desafio2.Controller;

import com.example.desafio2.Model.Desafio2Model;
import com.example.desafio2.Repositroy.DesafioRep;
import com.example.desafio2.Service.Testeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DesafioController {
    @Autowired
    DesafioRep desafioRep ;
    @GetMapping("/aaa/{cpf}")
    public ResponseEntity<Object> buscar(@PathVariable("cpf")String cpf){
        Optional<Desafio2Model> cpf0= desafioRep.findById(cpf);
        Testeservice testeservice = new Testeservice(cpf);
        if (cpf0.isEmpty()){
            if (testeservice.validacao()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("teste");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CPF não cadastro");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cpf0.get());
    }
}
