import java.time.LocalDateTime;
import java.util.HashMap;

public class Screening {

    private final Movie movie;
    private final LocalDateTime screeningTime;
    private final HashMap<String, Seat[]> seats;

    public Screening(Movie movie, LocalDateTime screeningTime, HashMap<String, Seat[]> seats) {
        this.movie = movie;
        this.screeningTime = screeningTime;
        this.seats = seats;
    }

    public static Screening of(Movie movie, LocalDateTime screeningTime,
        HashMap<String, Seat[]> seats) {
        return new Screening(movie, screeningTime, seats);
    }

}
