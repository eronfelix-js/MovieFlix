package com.felixDev.movieFliex.Controller.Response;

import lombok.Builder;

@Builder
public record CategoryResponse(long id, String name) {

}
