import java.time.LocalDate;

public class Movie {

    private String title;
    private LocalDate startScreeningDate;
    private LocalDate endScreeningDate;
    private int runningTimeMinutes;

    public Movie(String title, LocalDate startScreeningDate, LocalDate endScreeningDate,
        int runningTimeMinutes) {
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

    public int getRunningTimeMinutes() {
        return runningTimeMinutes;
    }
}
