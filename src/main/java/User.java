import java.util.ArrayList;

public class User {

    private String name;
    private int point;
    private ArrayList<Ticket> reservations;
    private WishList wishlist;

    public User(String name, int point) {
        this.name = name;
        this.point = point;
        this.reservations = new ArrayList<>();
        this.wishlist = new WishList();
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public ArrayList<Ticket> getReservations() {
        return reservations;
    }

    public WishList getWishlist() {
        return wishlist;
    }

    public void putInWishList(Ticket ticket) {
        this.wishlist.addTicket(ticket);
    }
}
