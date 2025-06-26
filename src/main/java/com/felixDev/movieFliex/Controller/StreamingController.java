package com.felixDev.movieFliex.Controller;

import com.felixDev.movieFliex.Controller.Request.StreamingRecord;
import com.felixDev.movieFliex.Controller.Response.CategoryResponse;
import com.felixDev.movieFliex.Controller.Response.StreamingResponse;
import com.felixDev.movieFliex.Entity.Streaming;
import com.felixDev.movieFliex.Mapper.CategoryMapper;
import com.felixDev.movieFliex.Mapper.StreamingMapper;
import com.felixDev.movieFliex.Service.StreamingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
public class StreamingController {

    @Autowired
    private StreamingService streamingService;

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@Valid @RequestBody StreamingRecord request){
        Streaming newStreaming = StreamingMapper.toRequest(request);
        Streaming saveStreaming = streamingService.criar(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body("O Streaming "+saveStreaming.getName()+" foi cadastrado com sucesso");

    }

    @GetMapping("/listartodos")
    public ResponseEntity<List<StreamingResponse>> listarTodos() {
        List<StreamingResponse> streamings = streamingService.listar()
                .stream()
                .map(StreamingMapper::toResponse)
                .toList();

        return ResponseEntity.ok(streamings);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<StreamingResponse> listarPorId(@PathVariable long id) {
        return streamingService.listarPorId(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletar(@PathVariable long id){
        streamingService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("streaming excluido com sucesso");
    }
}
