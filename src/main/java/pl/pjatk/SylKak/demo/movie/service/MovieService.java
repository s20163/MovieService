package pl.pjatk.SylKak.demo.movie.service;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import pl.pjatk.SylKak.demo.movie.exception.MovieNotFoundException;
import pl.pjatk.SylKak.demo.movie.model.Movie;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> listMovies() {
        return movieRepository.listAllMovies();
    }

    public Optional<Movie> getMovie(Long movieID) {
        if (movieRepository.listMovieById(movieID).isEmpty()) {
            throw new MovieNotFoundException();
        }
        return movieRepository.listMovieById(movieID);
    }

    public Movie postMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie putMovie(Long movieID, Movie movie) {
        if (!movieRepository.listMovieById(movieID).isEmpty()) {
            movie.setId(movieID);
            movie.setDurationInMin(movie.getDurationInMin());
            movie.setGenre(movie.getGenre());
            movie.setTitle(movie.getTitle());
            return movieRepository.save(movie);
        } else {
            return movie;
        }
    }

    public Movie putAvailability(Long movieID, Movie movie) {
        if (!movieRepository.listMovieById(movieID).isEmpty()) {
            movie.setId(movieID);
            movie.setAvailable(movie.isAvailable());
            return movieRepository.save(movie);
        } else {
            return movie;
        }
    }

    @Transactional
    @Modifying
    public void deleteMovie(Long movieID) {
        if (!movieRepository.listMovieById(movieID).isEmpty()) {
            movieRepository.deleteMovie(movieID);
        } else {
            throw new MovieNotFoundException();
        }
    }
}
