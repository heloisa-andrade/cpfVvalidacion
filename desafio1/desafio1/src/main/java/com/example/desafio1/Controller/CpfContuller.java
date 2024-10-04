package com.example.desafio1.Controller;


import com.example.desafio1.Repositorie.CPFRepository;
import com.example.desafio1.cpfDTO.CpfDto;
import com.example.desafio1.model.CpfModel;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

public class CpfContuller {
    @Autowired
    CPFRepository cpfRepository;
//    @PostMapping("/cpf_validacion")
//    public RestController cpfValidacion(){
//        var cpfModel = new CpfModel()
//    }

}
