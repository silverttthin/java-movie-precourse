import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

class UserTest {

    User user = new User("Lee", 10000);

    static final Movie movie = new Movie("귀칼",
        LocalDate.of(2025, 9, 1),
        LocalDate.of(2025, 9, 15),
        Duration.ofMinutes(230));

    @Test
    void 유저는티켓여러개를장바구니에담을수있다() throws Exception {

        Theater theater = new Theater();
        theater.addScreening(new Screening(movie,
            LocalDateTime.of(2025, 9, 15, 15, 30),
            theater.getSeats()
        ));
        theater.addScreening(new Screening(movie,
            LocalDateTime.of(2025, 9, 14, 15, 30),
            theater.getSeats()
        ));

        Screening screening1 = theater.searchByName("귀칼").getFirst();
        Screening screening2 = theater.searchByName("귀칼").getLast();

        Ticket ticket1 = screening1.issueTicket(user, 'A', 1);
        Ticket ticket2 = screening2.issueTicket(user, 'A', 1);
        user.putTicketsInWishList(List.of(ticket1, ticket2));

        assertThat(user.getWishlist().getTickets()).contains(ticket1);
        assertThat(user.getWishlist().getTickets()).contains(ticket2);

    }

    @Test
    void 유저는장바구니에있는티켓들을예매할수있다() throws Exception {

        Theater theater = new Theater();

        theater.addScreening(new Screening(movie,
            LocalDateTime.of(2025, 9, 15, 15, 30),
            theater.getSeats()
        ));

        Screening screening = theater.searchByName("귀칼").getFirst();

        screening.issueTicket(user, 'A', 1);

        user.pay();
    }

}
