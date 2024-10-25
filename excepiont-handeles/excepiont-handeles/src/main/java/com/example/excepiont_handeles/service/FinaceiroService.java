package com.example.excepiont_handeles.service;

import com.example.excepiont_handeles.dto.FinaceiroDTO;
import com.example.excepiont_handeles.exception.ValorZeroExcpiontion;
import org.springframework.stereotype.Service;

@Service
public class FinaceiroService {

    public FinaceiroDTO salvar(FinaceiroDTO finaceiroDTO){
        validarValores(finaceiroDTO);
        finaceiroDTO.setId(1L);
        return finaceiroDTO;
    }
    private  void validarValores(FinaceiroDTO finaceiro){
        if (finaceiro.getValor() == null || finaceiro.getValor().doubleValue() == 0){
        throw  new ValorZeroExcpiontion(
                "O valor do lançamento não pode ser 0 or null",
                finaceiro.getLancamento());}
    }
}
