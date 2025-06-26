package com.felixDev.movieFliex.Controller.Response;

import lombok.Builder;

@Builder
public record StreamingResponse(long id, String name) {

}
