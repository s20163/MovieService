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

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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
}
