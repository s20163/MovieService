package pl.pjatk.SylKak.demo.movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.SylKak.demo.movie.model.Movie;
import pl.pjatk.SylKak.demo.movie.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
        movieService.prepareMovies();
    }

    @GetMapping
    public ResponseEntity<List<Movie>> listAllMovies() {
        return new ResponseEntity(movieService.listMovies(), HttpStatus.OK);
    }
}
