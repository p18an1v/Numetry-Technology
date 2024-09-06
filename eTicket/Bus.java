import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Bus {

    static int seat[] = new int[10];
    ArrayList<Passenger> p = new ArrayList<>();
    ArrayList<Ticket> t = new ArrayList<>(); // added list of tickets
     private List<Ticket> bookings;

    public Bus() {
        bookings = new ArrayList<>();
    }

    public void addSeat(Passenger passenger, Ticket ticket) {
        p.add(passenger);
        t.add(ticket); // add ticket to list
        seat[ticket.getSeat()] = 1;
        bookings.add(ticket); // add ticket to bookings list
    }

    public void bookSeat(Passenger passenger, Ticket ticket){
        if(seat[ticket.getSeat()] == 0) {
            addSeat(passenger, ticket);
            System.out.println("Seat booked successfully.");
        } else {
            System.out.println("Seat is already booked.");
        }
    }

    public void cancelBooking(int ticketId) {
        boolean found = false;
        Iterator<Ticket> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getTicketId() == ticketId) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Booking canceled successfully!");
        } else {
            System.out.println("Booking not found!");
        }
    }
    

    public void updateBooking(int ticketId, int newSeat) {
        boolean found = false;
        for (Ticket ticket : bookings) {
            if (ticket.getTicketId() == ticketId) {
                ticket.setSeat(newSeat);
                found = true;
                System.out.println("Booking updated successfully!");
                break;  // Break out of the loop once the booking is found and updated
            }
        }
        if (!found) {
            System.out.println("Booking not found!");
        }
    }

    public void checkAvailableSpace() {
        int totalSeats = seat.length;
        int bookedSeats = bookings.size();
        int availableSeats = totalSeats - bookedSeats;
        System.out.println(availableSeats);
    }
    
    public void display() {
        System.out.println("--------------Passenger Details------------");
        for (int i = 0; i < p.size(); i++) {
            System.out.println("---------------------------------------");
            System.out.println("Passenger Name: " + p.get(i).getPassName());
            System.out.println("Mobile Number: " + p.get(i).getMobLong());
            System.out.println("Ticket ID: " + t.get(i).getTicketId());
            System.out.println("Date: " + t.get(i).getDate());
            System.out.println("Seat: " + t.get(i).getSeat());
            System.out.println("Seat Type: " + t.get(i).getSeat());
            System.out.println("----------------------------------------");
        }
    }     
}    