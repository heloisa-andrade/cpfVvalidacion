package com.example.testemongo.controller;

import com.example.testemongo.Repositroy.CpfRep;

import com.example.testemongo.model.Cpfmodel;
import com.example.testemongo.service.CpfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CpfController {
    @Autowired
    CpfRep cpfRep;
    //erroooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo
//    @PostMapping("/teste") //adiciona um documento
//    public ResponseEntity<Cpfmodel> addcpf (@RequestBody Cpfmodel cpfmodel){
//        return ResponseEntity.status(HttpStatus.CREATED).body(cpfRep.save(cpfmodel));
//
//    }
    @GetMapping("/teste/{cpf}")
    public ResponseEntity<Object> validacion (@PathVariable(value = "cpf")String cpf){
        Optional<Cpfmodel> prduct0 = cpfRep.findById(cpf);
        if (prduct0.isEmpty()){
            Cpfmodel cpfmodel = new Cpfmodel(cpf);
            return ResponseEntity.status(HttpStatus.OK).body(addcpf(cpfmodel));
        }else if (prduct0.equals(null)){

        }
        return ResponseEntity.status(HttpStatus.OK).body(prduct0.get());

    }
    @PostMapping("/teste") //adiciona um documento
    public ResponseEntity<Object> addcpf (@RequestBody Cpfmodel cpfmodel){
        CpfService cpfService = new CpfService(cpfmodel.getCpf());
        if (cpfService.validacao()) {
            cpfmodel.setCpf(cpfService.getCpf());
            return ResponseEntity.status(HttpStatus.CREATED).body(cpfRep.save(cpfmodel));
        }
        return ResponseEntity.status(HttpStatus.OK).body("Não foi possivel criar registro ");
    }
    @GetMapping("/cpf") // mostra todos os registos
    public ResponseEntity<List<Cpfmodel>> getAllProducts(){ //mostra todos os documentos
        return ResponseEntity.status(HttpStatus.OK).body(cpfRep.findAll());
    }
    @GetMapping("/cpf/{cpf}") // motra um documento em exeprecifico
    public ResponseEntity<Object> getOne(@PathVariable(value = "cpf")String cpf){
        Optional<Cpfmodel> prduct0 = cpfRep.findById(cpf);
        if (prduct0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(prduct0.get());
    }


    @DeleteMapping("/aaa/{id}")
    public ResponseEntity<Object> deleteCpf(@PathVariable(value = "cpf")String cpf){
        Optional<Cpfmodel> product0 = cpfRep.findById(cpf);
        if (product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");
        }
        cpfRep.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("product Delete  sucessfully");
    }
    @GetMapping("/validacion/{id}")
    public ResponseEntity<Object> cuidandoCpf(@PathVariable(value = "cpf")String cpf){
        Optional<Cpfmodel> prduct0 = cpfRep.findById(cpf);
        var cpfmodel = new Cpfmodel(cpf);
        if (prduct0.isEmpty()){
            CpfService cpfService = new CpfService(cpf);
            if (cpfService.validacao()){
                return ResponseEntity.status(HttpStatus.CREATED).body(cpfRep.save(cpfmodel));
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(prduct0.get());
    }

}
