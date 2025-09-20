import java.util.ArrayList;

public class WishList {

    private ArrayList<Ticket> tickets = new ArrayList<>();

    public WishList() {
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}
