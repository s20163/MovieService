package pl.pjatk.SylKak.demo.movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.SylKak.demo.movie.model.Movie;
import pl.pjatk.SylKak.demo.movie.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> listAllMovies() {
        return ResponseEntity.ok(movieService.listMovies());
    }

    @GetMapping("/{movieID}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable Long movieID) {
        return ResponseEntity.ok(movieService.getMovie(movieID));
    }

    @PostMapping
    public ResponseEntity<Movie> postMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.postMovie(movie));
    }

    @PutMapping("/{movieID}")
    public ResponseEntity<Movie> putMovie(@PathVariable Long movieID, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.putMovie(movieID, movie));
    }

    @DeleteMapping("/{movieID}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long movieID) {
        try {
            movieService.deleteMovie(movieID);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
