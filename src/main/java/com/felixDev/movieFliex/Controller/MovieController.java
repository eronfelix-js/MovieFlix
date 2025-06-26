package com.felixDev.movieFliex.Controller;

import com.felixDev.movieFliex.Controller.Request.MovieRecord;
import com.felixDev.movieFliex.Controller.Response.MovieResponse;
import com.felixDev.movieFliex.Entity.Movie;
import com.felixDev.movieFliex.Mapper.MovieMapper;
import com.felixDev.movieFliex.Service.MovieService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@Tag(name = "MOVIE" , description = "controla o gerenciamento dos filmes")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/criar")
    public ResponseEntity<MovieResponse> criarCategoria(@Valid @RequestBody MovieRecord request) {
        Movie saveMovie = movieService.criar(MovieMapper.toMovie(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(MovieMapper.toResponse(saveMovie));
    }

    @GetMapping("/listartodos")
    public List<MovieResponse> listarTodos() {
        List<Movie> movies = movieService.listarTodos();
        return movies.stream()
                .map(movie -> MovieMapper.toResponse(movie))
                .toList();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<MovieResponse> listarPorId(@PathVariable long id) {
        return movieService.listarPorID(id)
                .map(Movie -> ResponseEntity.ok(MovieMapper.toResponse(Movie)))
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> Deletar(@PathVariable long id) {
        movieService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<MovieResponse> alterar(@PathVariable long id,@Valid @RequestBody MovieRecord request){
        return movieService.alterar(id,MovieMapper.toMovie(request))
                .map(movie -> ResponseEntity.ok(MovieMapper.toResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> listarPorCategoria(@RequestParam long categoryID){
        return ResponseEntity.ok(
        movieService.listarFilmesPorCategoria(categoryID)
                .stream()
                .map(MovieMapper::toResponse)
                .toList()
    );
    }


}
