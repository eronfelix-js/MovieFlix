package com.felixDev.movieFliex.Mapper;


import com.felixDev.movieFliex.Controller.Request.MovieRecord;
import com.felixDev.movieFliex.Controller.Response.CategoryResponse;
import com.felixDev.movieFliex.Controller.Response.MovieResponse;
import com.felixDev.movieFliex.Controller.Response.StreamingResponse;
import com.felixDev.movieFliex.Entity.Category;
import com.felixDev.movieFliex.Entity.Movie;
import com.felixDev.movieFliex.Entity.Streaming;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Stream;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRecord movieRecord){

        List<Category> categoryList = movieRecord.categories().stream()
                .map(categoryID -> Category.builder().id(categoryID).build())
                .toList();

        List<Streaming> streamingList = movieRecord.streaming().stream()
                .map(streamingID -> Streaming.builder().id(streamingID).build())
                .toList();

        return Movie.builder()
                .tittle(movieRecord.tittle())
                .description(movieRecord.description())
                .rating(movieRecord.rating())
                .releaseDate(movieRecord.releaseDate())
                .categories(categoryList)
                .streaming(streamingList)
                .build();
    }

    public static MovieResponse toResponse(Movie movie){

        List<CategoryResponse> categoryResponses = movie.getCategories()
                .stream()
                .map(category -> CategoryMapper.toResponse(category))
                .toList();

        List<StreamingResponse> streamingResponses = movie.getStreaming()
                .stream()
                .map(streaming -> StreamingMapper.toResponse(streaming))
                .toList();

        return MovieResponse.builder()
                .id(movie.getId())
                .tittle(movie.getTittle())
                .description(movie.getDescription())
                .rating(movie.getRating())
                .releaseDate(movie.getReleaseDate())
                .categories(categoryResponses)
                .streaming(streamingResponses)
                .build();
    }
}
