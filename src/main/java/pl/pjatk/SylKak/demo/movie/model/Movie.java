package pl.pjatk.SylKak.demo.movie.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Movie.listAllMovies",
                query = "SELECT m FROM Movie m"),
        @NamedQuery(name = "Movie.listMovieById",
                query = "SELECT m FROM Movie m WHERE m.id = ?1"),
        @NamedQuery(name = "Movie.deleteMovie",
                query = "DELETE FROM Movie m WHERE m.id = ?1")
})
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private MovieGenre genre;
    @Column(name = "duration_in_min")
    private int durationInMin;
    @Column(name = "isAvailable", columnDefinition = "TINYINT(1)")
    private boolean isAvailable;

    public Movie(long id, String title, MovieGenre genre, int durationInMin, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.durationInMin = durationInMin;
        this.isAvailable = isAvailable;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public void setGenre(MovieGenre genre) {
        this.genre = genre;
    }

    public int getDurationInMin() {
        return durationInMin;
    }

    public void setDurationInMin(int durationInMin) {
        this.durationInMin = durationInMin;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
