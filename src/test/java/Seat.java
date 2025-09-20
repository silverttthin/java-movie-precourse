public class Seat {

    private final SeatGrade seatGrade;
    private boolean isOccupied;

    public Seat(SeatGrade seatGrade) {
        this.seatGrade = seatGrade;
        this.isOccupied = false;
    }

    public void occupy() {
        this.isOccupied = true;
    }
}
