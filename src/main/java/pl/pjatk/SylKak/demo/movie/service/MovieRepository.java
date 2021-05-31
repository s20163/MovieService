package pl.pjatk.SylKak.demo.movie.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.SylKak.demo.movie.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Override
    List<Movie> findAll(Sort sort);

    Optional<Movie> findById(Long id);

    @Override
    <S extends Movie> S save(S s);

    void deleteById(Long id);
}
