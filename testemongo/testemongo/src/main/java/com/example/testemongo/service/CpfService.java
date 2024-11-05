package com.example.testemongo.service;

import com.example.testemongo.Repositroy.CpfRep;
import com.example.testemongo.exception.ValidacionError;
import com.example.testemongo.model.CpfModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;

@Service
public class CpfService {
    private String cpf;

    public CpfService(String cpf) {
        this.cpf = cpf;
    }

    public CpfService() {
    }

    public String getCpf() {
        return cpf;
    }

    public boolean validacao(){
        int soma = 0;
        int numero;
        int numero1Verificado=0;
        int numero2Verificado=0;
        char separado;
        int verificador = 0;
        LinkedList<Integer> cpfnumero =new LinkedList<>();
        int contador=-1;
        try {
            do {
                try {
                    contador++;
                    separado = this.cpf.charAt(contador);
                    numero = Integer.parseInt(String.valueOf(separado));
                    cpfnumero.add(numero);
                } catch (NumberFormatException nfe) {

                }
            } while (contador < cpf.length() - 1);

            if (cpfnumero.size() == 11) {

                contador = 10;
                for (int i = 0; i < 9; i++) {
                    soma += (cpfnumero.get(i) * contador);
                    contador--;
                }
                verificador = 11 - soma % 11;
                if (verificador >= 10) {
                    numero1Verificado = 0;
                } else {
                    numero1Verificado = verificador;
                }
                contador = 10;
                soma = 0;
                for (int i = 1; i < 10; i++) {
                    soma += (cpfnumero.get(i) * contador);
                    contador--;
                }
                verificador = (soma % 11);

                verificador = 11 - verificador;
                if (verificador >= 10) {
                    numero2Verificado = 0;
                } else {
                    numero2Verificado = verificador;
                }

            } else {
                return false;
            }
            this.cpf = "";
            for (int i = 0; i < 11; i++) {
                cpf += cpfnumero.get(i);
            }
            int n1 = cpfnumero.get(9);
            int n2 = cpfnumero.get(10);
            return (n1 == numero1Verificado) && (n2 == numero2Verificado);
        }catch (NullPointerException nullPointerException){
            return false;
        }catch (IndexOutOfBoundsException e){
            return false;
        }
    }
    public ResponseEntity<Object> save(CpfModel cpfModel, CpfRep cpfRep){
        return validarValores(cpfModel,cpfRep);
    }

    private ResponseEntity<Object> validarValores(CpfModel cpfModel,CpfRep cpfRep){
        cpf = cpfModel.getCpf();
        if (cpf.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Cpf null!");
        }else if (!validacao()){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Cpf não valido");
        }
        Optional<CpfModel> cpf0= cpfRep.findById(cpf);
        cpfModel.setCpf(this.cpf);
        if (cpf0.isEmpty()) {
            cpfModel.setIsValidacion(true);
            return ResponseEntity.status(HttpStatus.CREATED).body(cpfRep.save(cpfModel));
        }
        return ResponseEntity.status(HttpStatus.OK).body("Cpf ja validado");


    }
}
