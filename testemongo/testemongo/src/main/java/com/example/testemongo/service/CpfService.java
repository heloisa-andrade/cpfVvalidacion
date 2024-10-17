package com.example.testemongo.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
@Service
public class CpfService {
    private String cpf;

    public CpfService(String cpf) {
        this.cpf = cpf;
    }

    public CpfService() {
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
        do {
            try {
                contador ++;
                separado = this.cpf.charAt(contador);
                numero = Integer.parseInt(String.valueOf(separado));
                cpfnumero.add(numero);
            }catch (NumberFormatException nfe){
                System.out.println("aaaa");
            }
        }while (contador < this.cpf.length()-1);

        if (cpfnumero.size() == 11){
            contador = 10;
            for (int i = 0; i < 9; i++) {
                soma += (cpfnumero.get(i)*contador);
                contador--;
            }
            verificador = 11 - soma % 11;
            numero1Verificado = verificador;
            contador = 10;
            soma = 0;
            for (int i = 1; i < 10; i++) {
                soma += (cpfnumero.get(i)*contador);
                contador--;
            }
            verificador = (soma % 11);
            verificador = 11 - verificador;
            numero2Verificado = verificador;
        }else {
            return false;
        }
        int n1 = cpfnumero.get(9);
        int n2 = cpfnumero.get(10);
        return (n1 == numero1Verificado) && (n2 == numero2Verificado);
    }
}
