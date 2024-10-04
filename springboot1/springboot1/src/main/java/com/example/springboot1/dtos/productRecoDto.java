package com.example.springboot1.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record productRecoDto(@NotBlank String nome,@NotNull BigDecimal value) {

}
