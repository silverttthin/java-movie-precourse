import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TheaterTest {

    static final Theater theater = new Theater();
    static final Movie movie = new Movie("귀칼",
        LocalDate.of(2025, 9, 1),
        LocalDate.of(2025, 9, 15),
        230);

    @BeforeAll
    static void setUp() {
    }

    @Test
    void 영화관은_상영을_등록할_수_있다() throws Exception {
        LocalDateTime screeningTime = LocalDateTime.of(2025, 9, 12, 15, 30);

        Screening screening = new Screening(movie, screeningTime, theater.getSeats());

        theater.addScreening(screening);

        assertEquals(1, theater.getScreenings().size());
    }

    @Test
    void 상영가능기간이전의영화는등록할수없다() throws Exception {
        LocalDateTime screeningTime = LocalDateTime.of(2025, 8, 30, 15, 30);

        Screening screening = new Screening(movie, screeningTime, theater.getSeats());

        Exception exception = assertThrows(Exception.class, () -> theater.addScreening(screening));

        assertEquals("영화가 상영가능한 시작일보다 상영일이 전입니다", exception.getMessage());

    }

    @Test
    void 상영가능기간이후의영화는등록할수없다() throws Exception {
        LocalDateTime screeningTime = LocalDateTime.of(2025, 10, 30, 15, 30);

        Screening screening = new Screening(movie, screeningTime, theater.getSeats());

        Exception exception = assertThrows(Exception.class, () -> theater.addScreening(screening));

        assertEquals("영화가 상영가능한 종료일보다 상영일이 후입니다", exception.getMessage());

    }


}
