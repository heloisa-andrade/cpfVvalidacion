package com.example.desafio1.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;
@Setter
@Getter
@Document(collation = "desfio")
public class CpfModel implements Serializable {
    //certo
    private static final long serialVersionUID = 1L;
    @Id
    private UUID id;
//    @NonNull
    private String cpf;
    public CpfModel(String cpf) {
        this.cpf = cpf;
    }
    public CpfModel() {}
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
        }while (contador < cpf.length()-1);

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
