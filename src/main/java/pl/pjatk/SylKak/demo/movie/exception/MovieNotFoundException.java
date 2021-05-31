package pl.pjatk.SylKak.demo.movie.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String msg) {
        super(msg);
    }
}
