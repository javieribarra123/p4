package edu.icai.p4;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Raza(
        @NotBlank String nombre,
        @NotNull String tamaño,
        @NotNull Integer altura,
        @NotNull Integer peso
){}
