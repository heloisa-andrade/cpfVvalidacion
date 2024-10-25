package com.example.excepiont_handeles.dto;

import com.fasterxml.jackson.annotation.JsonTypeId;

import java.math.BigDecimal;

public class FinaceiroDTO {
    private Long Id;
    private BigDecimal valor;
    private String lancamento;

    public FinaceiroDTO() {
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
