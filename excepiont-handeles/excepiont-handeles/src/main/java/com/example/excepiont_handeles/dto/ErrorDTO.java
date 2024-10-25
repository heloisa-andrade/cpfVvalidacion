package com.example.excepiont_handeles.dto;

public class ErrorDTO {
    private String mensagem;
    private String Lancamento;

    public ErrorDTO(String mensagem, String lancamento) {
        this.mensagem = mensagem;
        Lancamento = lancamento;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getLancamento() {
        return Lancamento;
    }

    public void setLancamento(String lancamento) {
        Lancamento = lancamento;
    }
}
