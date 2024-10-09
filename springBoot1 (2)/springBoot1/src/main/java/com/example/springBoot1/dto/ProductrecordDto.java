package com.example.springBoot1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductrecordDto(@NotBlank  String name, @NotNull BigDecimal valor) {

}
