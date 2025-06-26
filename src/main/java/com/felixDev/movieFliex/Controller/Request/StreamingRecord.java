package com.felixDev.movieFliex.Controller.Request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record StreamingRecord(@NotEmpty(message = "O nome do streaming é obrigatorio") String name) {
}
