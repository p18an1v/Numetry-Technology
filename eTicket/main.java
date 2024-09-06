import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Bus bus = new Bus();

        while (true) {

            System.out.println("---------welcome---------");
            System.out.println("1. Book a seat");
            System.out.println("2. Cancel a booking");
            System.out.println("3. Update a booking");
            System.out.println("4. Display all bookings");
            System.out.println("5. Check Avialable set");
            System.out.println("6. exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter passenger name: ");
                    String passName = sc.next();
                    System.out.print("Enter mobile number: ");
                    Long mobLong = sc.nextLong();
                    System.out.print("Enter ticket ID: ");
                    int ticketId = sc.nextInt();
                    System.out.print("Enter date (dd/MM/yyyy): ");
                    String dateStr = sc.next();
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                    System.out.print("Enter seat number: ");
                    int seat = sc.nextInt();
                    System.out.print("Enter seat type: ");
                    String seatType = sc.next();
                    Passenger passenger = new Passenger(passName, mobLong);
                    Ticket ticket = new Ticket(ticketId, date, seat);
                    bus.bookSeat(passenger, ticket);
                    break;
                case 2:
                    System.out.print("Enter ticket ID to cancel the booking: ");
                    int cancelTicketId = sc.nextInt();
                    bus.cancelBooking(cancelTicketId);
                    break;
                case 3:
                    System.out.print("Enter ticket ID to update the booking: ");
                    int updateTicketId = sc.nextInt();
                    System.out.print("Enter new seat number: ");
                    int newSeat = sc.nextInt();
                    bus.updateBooking(updateTicketId, newSeat);
                    break;
                case 4:
                    bus.display();
                    break;
                case 5:
                    bus.checkAvailableSpace();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
