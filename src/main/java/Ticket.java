public class Ticket {

    private User User;
    private Screening screening;
    private char row;
    private int column;

    public Ticket(User user, Screening screening, char row, int column) {
        User = user;
        this.screening = screening;
        this.row = row;
        this.column = column;
        screening.getSeats().get(row)[column].occupy();
    }

    public User getUser() {
        return User;
    }

    public Screening getScreening() {
        return screening;
    }

    public char getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
