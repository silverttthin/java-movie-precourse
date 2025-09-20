package movie;

import java.util.ArrayList;
import java.util.List;

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

    public void addTicketAll(List<Ticket> tickets) {
        this.tickets.addAll(tickets);
    }
}
