package com.felixDev.movieFliex.Service;

import com.felixDev.movieFliex.Entity.Category;
import com.felixDev.movieFliex.Entity.Movie;
import com.felixDev.movieFliex.Entity.Streaming;
import com.felixDev.movieFliex.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StreamingService streamingService;

    public List<Movie> listarTodos(){
        return movieRepository.findAll();
    }

    public Optional<Movie> listarPorID(long id){
        Optional<Movie> listarId = movieRepository.findById(id);
        return listarId;
    }

    public List<Movie> listarFilmesPorCategoria(long categoryId){
        return movieRepository.findMoviesBycategories(List.of(Category.builder().id(categoryId).build()));
    }



    public List<Streaming> listarStreaming(List<Streaming> streamings){
        List<Streaming> streamingList = new ArrayList<>();
        streamings.forEach(streaming -> streamingService.listarPorId(streaming.getId()).ifPresent(streamingList::add));
        return streamingList;
    }

    public List<Category> listarCategoria(List<Category> categories){
        List<Category> categoryList =new ArrayList<>();
        categories.forEach(category -> categoryService.listarPorID(category.getId()).ifPresent(categoryList::add));
        return categoryList;
    }

    public Movie criar(Movie movie){
        movie.setCategories(listarCategoria(movie.getCategories()));
        movie.setStreaming(listarStreaming(movie.getStreaming()));
        return movieRepository.save(movie);
    }


    public Optional<Movie> alterar(long id, Movie movieUpdat){
        Optional<Movie> movieById = movieRepository.findById(id);
        if (movieById.isPresent()) {

          List<Category> categories = this.listarCategoria(movieUpdat.getCategories());
            List<Streaming> streamingList = this.listarStreaming(movieUpdat.getStreaming());


            Movie movie = movieById.get();
            movie.setTittle(movieUpdat.getTittle());
            movie.setDescription(movieUpdat.getDescription());
            movie.setRating(movieUpdat.getRating());
            movie.setReleaseDate(movieUpdat.getReleaseDate());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreaming().clear();
            movie.getStreaming().addAll(streamingList);

            movieRepository.save(movie);
            return Optional.of(movie);
        }
        return Optional.empty();
    }

    public void deletar(Long id){
        movieRepository.deleteById(id);
    }

}
