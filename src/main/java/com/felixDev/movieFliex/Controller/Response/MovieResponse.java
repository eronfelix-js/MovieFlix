package com.felixDev.movieFliex.Controller.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record MovieResponse(Long id,
                            String tittle,
                            String description,

                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                            LocalDate releaseDate,
                            Double rating,
                            List<CategoryResponse>categories,
                            List<StreamingResponse> streaming) {
}
