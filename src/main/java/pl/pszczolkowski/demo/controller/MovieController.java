package pl.pszczolkowski.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.pszczolkowski.demo.annotation.MovieAnnotation;
import pl.pszczolkowski.demo.service.MovieService;
import pl.pszczolkowski.demo.model.Movie;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getMovieList();
    }

    @PostMapping
    @MovieAnnotation
    public Movie addFilm(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return movie;
    }
}
