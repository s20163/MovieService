package pl.pjatk.SylKak.demo.movie.model;

public class Movie {
    private Long ID;
    private String title;
    private MovieGenre genre;
    private int durationInMin;

    public Movie(long ID, String title, MovieGenre genre, int durationInMin) {
        this.ID = ID;
        this.title = title;
        this.genre = genre;
        this.durationInMin = durationInMin;
    }
}
