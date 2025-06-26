package com.felixDev.movieFliex.Repository;

import com.felixDev.movieFliex.Entity.Category;
import com.felixDev.movieFliex.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findMoviesBycategories(List<Category> categories);
}
