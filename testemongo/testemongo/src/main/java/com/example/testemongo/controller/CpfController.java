package com.example.testemongo.controller;

import com.example.testemongo.Repositroy.CpfRep;

import com.example.testemongo.model.CpfModel;
import com.example.testemongo.service.CpfService;
import com.example.testemongo.service.TesteError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CpfController {
//    @Autowired
//    CpfRep cpfRep;
//
//    @GetMapping("/teste/{cpf}")
//    public ResponseEntity<Object> validacion (@PathVariable(value = "cpf") String cpf){
//        Optional<CpfModel> cpf0= cpfRep.findById(cpf);
//        if (cpf0.isEmpty()){
//            CpfModel cpfmodel = new CpfModel(cpf);
//            return ResponseEntity.status(HttpStatus.OK).body(addcpf(cpfmodel));
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(cpf0.get());
//
//    }
//    @PostMapping("/teste")
//    public ResponseEntity<Object> addcpf (@RequestBody CpfModel cpfmodel){
//        CpfService cpfService = new CpfService(cpfmodel.getCpf());
//        Optional<CpfModel> cpf0= cpfRep.findById(cpfmodel.getCpf());
//        if (cpf0.isEmpty()) {
//            if (cpfService.validacao()) {
//                cpfmodel.setCpf(cpfService.getCpf());
//                return ResponseEntity.status(HttpStatus.CREATED).body(cpfRep.save(cpfmodel));
//            }
//            return ResponseEntity.status(HttpStatus.OK).body("Não foi possivel criar registro ");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body("aaaa");
//    }
//    //arrumar
//    @PostMapping("/arrumado")
//    public ResponseEntity<Object> teste (@RequestBody CpfModel cpfmodel){
//        CpfService cpfService = new CpfService(cpfmodel.getCpf());
//        Optional<CpfModel> cpf0= cpfRep.findById(cpfmodel.getCpf());
//        if (cpf0.isEmpty()){
//            if (cpfService.validacao()){
//                cpfmodel.setCpf(cpfService.getCpf());
//                cpfmodel.setIsValidacion("true");
//                return ResponseEntity.status(HttpStatus.CREATED).body(cpfRep.save(cpfmodel));
//            }
//            return ResponseEntity.status(HttpStatus.OK).body("Não foi possivel criar registro ");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(cpf0.get());
//    }
//    @GetMapping("/cpf")
//    public ResponseEntity<List<CpfModel>> getAllProducts(){
//        return ResponseEntity.status(HttpStatus.OK).body(cpfRep.findAll());
//    }
//    @GetMapping("/cpf/{cpf}")
//    public ResponseEntity<Object> getOne(@PathVariable(value = "cpf")String cpf){
//        Optional<CpfModel> cpf0= cpfRep.findById(cpf);
//        if (cpf0.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(cpf0.get());
//    }
//
//
//    @DeleteMapping("/aaa/{id}")
//    public ResponseEntity<Object> deleteCpf(@PathVariable(value = "cpf")String cpf){
//        Optional<CpfModel> product0 = cpfRep.findById(cpf);
//        if (product0.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product not found");
//        }
//        cpfRep.delete(product0.get());
//        return ResponseEntity.status(HttpStatus.OK).body("product Delete  sucessfully");
//    }
    @Autowired
    TesteError error;
    @PostMapping("/n")
    public CpfModel salvar(@RequestBody  CpfModel cpfModel){
        return null;
    }


}
