import java.util.Date;

public class Ticket {
    private int ticketId;
    private Date date;
    private int seat;

    public Ticket(int ticketId, Date date, int seat) {
        this.ticketId = ticketId;
        this.date = date;
        this.seat = seat;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
}