package pl.pjatk.SylKak.demo.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.SylKak.demo.movie.model.Movie;
import pl.pjatk.SylKak.demo.movie.model.MovieGenre;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> list = new ArrayList<>();

    public void prepareMovies() {
        Movie hp1 = new Movie(1, "Harry Potter and the Philosopher's Stone", MovieGenre.FANTASY, 152);
        Movie lotr1 = new Movie(2, "LotR: The Fellowship of the Ring", MovieGenre.FANTASY, 208);
        list.add(hp1);
        list.add(lotr1);
    }

    public List<Movie> listMovies() {
        return list;
    }
}
