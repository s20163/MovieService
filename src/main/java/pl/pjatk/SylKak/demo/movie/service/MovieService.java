package pl.pjatk.SylKak.demo.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.SylKak.demo.movie.model.Movie;
import pl.pjatk.SylKak.demo.movie.model.MovieGenre;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public List<Movie> listMovies(boolean shouldList) {
        if(shouldList){
            Movie hp1 = new Movie(1, "Harry Potter and the Philosopher's Stone", MovieGenre.FANTASY, 152);
            Movie lotr1 = new Movie(2, "LotR: The Fellowship of the Ring", MovieGenre.FANTASY, 208);
            List<Movie> list = new ArrayList<Movie>();
            list.add(hp1);
            list.add(lotr1);
            return list;
        }else{
            throw new RuntimeException();
        }
    }
}
