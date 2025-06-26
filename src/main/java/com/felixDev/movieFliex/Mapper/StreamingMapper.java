package com.felixDev.movieFliex.Mapper;

import com.felixDev.movieFliex.Controller.Request.StreamingRecord;
import com.felixDev.movieFliex.Controller.Response.StreamingResponse;
import com.felixDev.movieFliex.Entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toRequest(StreamingRecord streamingRecord){
        return Streaming
                .builder()
                .name(streamingRecord.name())
                .build();
    }

    public static StreamingResponse toResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .name(streaming.getName())
                .id(streaming.getId())
                .build();
    }
}
