package com.felixDev.movieFliex.Controller.Response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String name, String email) {
}
