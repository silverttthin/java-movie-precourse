package movie;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Screening {

    private final Movie movie;
    private final LocalDateTime screeningTime;
    private final HashMap<Character, Seat[]> seats;

    public Screening(Movie movie, LocalDateTime screeningTime, HashMap<Character, Seat[]> seats) {
        this.movie = movie;
        this.screeningTime = screeningTime;
        this.seats = seats;
    }


    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getScreeningTime() {
        return screeningTime;
    }

    public HashMap<Character, Seat[]> getSeats() {
        return seats;
    }

    public boolean isSameMovieName(String searchKeyword) {
        return this.movie.getTitle().equals(searchKeyword);
    }

    public Ticket issueTicket(User user, char a, int i) {
        return new Ticket(
            user,
            this,
            a,
            i
        );
    }
}
