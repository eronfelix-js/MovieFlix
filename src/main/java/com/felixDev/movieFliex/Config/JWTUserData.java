package com.felixDev.movieFliex.Config;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String name, String email) {
}
