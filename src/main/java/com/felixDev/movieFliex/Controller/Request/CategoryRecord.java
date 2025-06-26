package com.felixDev.movieFliex.Controller.Request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRecord(@NotEmpty(message = "O nome da categoria é obrigatorio!") String name) {
}
