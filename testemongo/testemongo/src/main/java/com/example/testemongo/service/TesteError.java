package com.example.testemongo.service;

import com.example.testemongo.exception.ValidacionError;
import com.example.testemongo.model.CpfModel;
import org.springframework.stereotype.Service;

@Service
public class TesteError {

    public CpfModel save(CpfModel cpfModel){
        validarValores(cpfModel);
        return cpfModel;
    }
    private void  validarValores(CpfModel cpfModel){
        if (cpfModel.getCpf().isEmpty()){
            CpfService cpfService = new CpfService(cpfModel.getCpf());

            if (!cpfService.validacao()){
                throw new ValidacionError("Não foi possivel validar o cpf", cpfModel.getCpf());
            }
        }

    }
}
