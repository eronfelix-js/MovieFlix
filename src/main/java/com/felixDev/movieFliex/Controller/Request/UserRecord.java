package com.felixDev.movieFliex.Controller.Request;

import lombok.Builder;
import org.hibernate.tool.schema.spi.SchemaTruncator;

@Builder
public record UserRecord(String name, String email, String password) {
}
