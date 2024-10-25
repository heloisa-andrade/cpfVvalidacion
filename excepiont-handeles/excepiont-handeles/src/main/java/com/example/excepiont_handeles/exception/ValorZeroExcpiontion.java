package com.example.excepiont_handeles.exception;

public class ValorZeroExcpiontion extends  RuntimeException{
    private final String lancamento;

    public ValorZeroExcpiontion(String message, String lancamento) {
        super(message);
        this.lancamento = lancamento;
    }

    public String getLancamento() {
        return lancamento;
    }

}
