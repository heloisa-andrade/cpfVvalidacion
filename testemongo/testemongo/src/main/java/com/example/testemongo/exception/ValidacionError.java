package com.example.testemongo.exception;

public class ValidacionError extends RuntimeException {
  private final String cpf;

  public ValidacionError(String message, String cpf) {
    super(message);
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }
}
