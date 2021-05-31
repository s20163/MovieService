package pl.pjatk.SylKak.demo.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.SylKak.demo.movie.exception.MovieNotFoundException;
import pl.pjatk.SylKak.demo.movie.model.Movie;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovie(Long movieID) {
        if (movieRepository.findById(movieID).isEmpty()) {
            throw new MovieNotFoundException("404 Movie not found");
        }
        return movieRepository.findById(movieID);
    }

    public Movie postMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie putMovie(Long movieID, Movie movie) {
        if (!movieRepository.findById(movieID).isEmpty()) {
            movie.setId(movieID);
            movie.setDurationInMin(movie.getDurationInMin());
            movie.setGenre(movie.getGenre());
            movie.setTitle(movie.getTitle());
            return movieRepository.save(movie);
        } else {
            return movie;
        }
    }

    public void deleteMovie(Long movieID) {
        movieRepository.deleteById(movieID);
    }
}
