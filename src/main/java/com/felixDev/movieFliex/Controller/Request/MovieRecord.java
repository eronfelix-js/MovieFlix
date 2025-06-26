package com.felixDev.movieFliex.Controller.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRecord(@NotEmpty(message = "o titulo do filme é obrigatorio") String tittle,
                          String description,
                          @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                          LocalDate releaseDate,
                          Double rating,
                          List<Long> categories,
                          List<Long> streaming
) { }
