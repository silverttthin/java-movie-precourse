import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Theater {

    private ArrayList<Screening> screenings = new ArrayList<>();
    private HashMap<Character, Seat[]> seats = new HashMap<>();
    // max Row, max Column

    public Theater() {

        for (char row = 'A'; row <= 'E'; row++) {
            Seat[] seat = new Seat[5];
            this.seats.put(row, seat);
        }

    }

    public HashMap<Character, Seat[]> getSeats() {
        return seats;
    }

    public void addScreening(Screening screening) throws Exception {

        LocalDate startScreeningDate = screening.getMovie().getStartScreeningDate();
        LocalDate endScreeningDate = screening.getMovie().getEndScreeningDate();
        LocalDate screeningTime = screening.getScreeningTime().toLocalDate();

        // 영화가 상영가능한 시작일보다 상영일이 전이면 안됨
        // 영화가 상영가능한 종료일보다 상영일이 후이면 안됨
        if (screeningTime.isBefore(startScreeningDate)) {
            throw new Exception("영화가 상영가능한 시작일보다 상영일이 전입니다");
        }

        if (screeningTime.isAfter(endScreeningDate)) {
            throw new Exception("영화가 상영가능한 종료일보다 상영일이 후입니다");
        }

        this.screenings.add(screening);
    }

    public ArrayList<Screening> getScreenings() {
        return screenings;
    }
}
