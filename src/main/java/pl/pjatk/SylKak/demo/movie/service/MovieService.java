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

    public Movie getMovie(Long movieID) {
        Movie movie = list.stream().filter(m -> m.getID().equals(movieID)).findFirst().get();
        return movie;
    }

    public Movie postMovie(Movie movie) {
        list.add(movie);
        return movie;
    }

    public Movie putMovie(Long movieID, Movie movie) {
        for (Movie m : list) {
            if (m.getID().equals(movieID)) {
                m.setTitle(movie.getTitle());
                m.setGenre(movie.getGenre());
                m.setDurationInMin(movie.getDurationInMin());
            }
        }
        return movie;
    }

    public boolean deleteMovie(Long movieID) {
        return list.removeIf(m -> m.getID().equals(movieID));
    }
}
