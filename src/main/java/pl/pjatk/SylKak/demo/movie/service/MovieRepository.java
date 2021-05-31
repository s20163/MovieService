package pl.pjatk.SylKak.demo.movie.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import pl.pjatk.SylKak.demo.movie.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {


    List<Movie> listAllMovies();

    Optional<Movie> listMovieById(Long id);

    <S extends Movie> S save(S s);

    @Modifying
    void deleteMovie(Long id);
}
