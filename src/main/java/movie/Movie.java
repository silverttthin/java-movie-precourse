package movie;

import java.time.Duration;
import java.time.LocalDate;

public class Movie {

    private String title;
    private LocalDate startScreeningDate;
    private LocalDate endScreeningDate;
    private Duration runningTimeMinutes;

    public Movie(String title, LocalDate startScreeningDate, LocalDate endScreeningDate,
        Duration runningTimeMinutes) {
        this.title = title;
        this.startScreeningDate = startScreeningDate;
        this.endScreeningDate = endScreeningDate;
        this.runningTimeMinutes = runningTimeMinutes;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getStartScreeningDate() {
        return startScreeningDate;
    }

    public LocalDate getEndScreeningDate() {
        return endScreeningDate;
    }

    public Duration getRunningTimeMinutes() {
        return runningTimeMinutes;
    }
}
