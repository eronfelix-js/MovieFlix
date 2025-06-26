package com.felixDev.movieFliex.Controller.Request;

import lombok.Builder;

@Builder
public record LoginRecord(String email, String password) {
}
