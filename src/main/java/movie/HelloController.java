package movie;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    ArrayList<Movie> movies = new ArrayList<>();
    Theater theater = new Theater();
    User user = new User("lee", 10000);

    @GetMapping
    public ArrayList<Movie> getMovies() {

        Movie movie1 = new Movie("귀칼",
            LocalDate.of(2025, 9, 1),
            LocalDate.of(2025, 9, 15),
            Duration.ofMinutes(230)
        );

        Movie movie2 = new Movie("인터스텔라",
            LocalDate.of(2025, 9, 5),
            LocalDate.of(2025, 9, 20),
            Duration.ofMinutes(169)
        );

        Movie movie3 = new Movie("어벤져스: 엔드게임",
            LocalDate.of(2025, 9, 10),
            LocalDate.of(2025, 9, 30),
            Duration.ofMinutes(181)
        );

        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);

        return movies;
    }

    public record TicketDto(
        String movieName,
        String humanName,
        LocalDateTime issuedAt
    ) {

    }

    @GetMapping("/movies")
    public TicketDto bookMovie(@RequestParam String movieName) throws Exception {

        movies = getMovies();

        Movie movie = movies.stream()
            .filter(
                _movie -> _movie.getTitle().equals(movieName)
            )
            .findFirst()
            .orElseThrow(() -> new Exception(movieName + "이란 영화는 없습니다."));

        Screening screening = new Screening(
            movie,
            LocalDateTime.now(),
            theater.getSeats()
        );

        Ticket issuedTicket = screening.issueTicket(
            user,
            'A',
            3
        );

        System.out.println(issuedTicket);

        user.putInWishList(issuedTicket);

        return new TicketDto(
            movie.getTitle(),
            user.getName(),
            LocalDateTime.now()
        );

    }
}
