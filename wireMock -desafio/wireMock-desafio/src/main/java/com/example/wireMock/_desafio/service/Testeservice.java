package com.example.wireMock._desafio.service;

import com.example.wireMock._desafio.model.CepModel;
import com.example.wireMock._desafio.model.CpfModel;
import com.example.wireMock._desafio.model.PessoaModel;
import com.example.wireMock._desafio.repositroy.CepRep;
import com.example.wireMock._desafio.repositroy.CpfRep;
import com.example.wireMock._desafio.repositroy.PessoaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class Testeservice {
    private String cpf;

    public Testeservice(PessoaRep photoConsumerFeign) {
        this.photoConsumerFeign = photoConsumerFeign;
    }

    public String getCpf() {
        return cpf;
    }
    @Autowired
    private PessoaRep photoConsumerFeign;

    @Autowired
    private CepRep cepRep;
    public ResponseEntity<Object> valisdar(CpfModel cpfModel, CpfRep cpfRep ){
        cpf = cpfModel.getCpf();
        if (cpf.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Cpf null!");
        }
        Optional<CpfModel> cpf0= cpfRep.findById(cpf);
//        if (cpf0.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não cadastrado");
//        }
        return ResponseEntity.status(HttpStatus.OK).body(teste(cpfModel));
    }



    private ResponseEntity<Object> teste (CpfModel cpfModel){
        PessoaModel aaaaa = photoConsumerFeign.getPessoa(cpfModel.getCpf());
        return ads(aaaaa);
    }

    private ResponseEntity<Object>ads(PessoaModel pessoaModel){
        String aaaaa =cepRep.getCep(pessoaModel.getCEP()).toString();
        return ResponseEntity.status(HttpStatus.OK).body(aaaaa);
    }
}
