import java.util.Scanner;

public class mainMethod {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.setLimit();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n------- Hotel -------");
            System.out.println("1. Check Available Desks");
            System.out.println("2. Enter Guest");
            System.out.println("3. Exit Guest");
            System.out.println("4. Display Records");
            System.out.println("5. Number Of Guests for Meal");
            System.out.println("6. Stop");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.err.println();

            switch (choice) {
                case 1:
                    System.out.println("Available Desks: " + hotel.availableDesks());
                    break;
                case 2:
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    GuestRecord guest = new GuestRecord(name);
                    System.out.print("Enter guest ID: ");
                    int guestId = scanner.nextInt();
                    hotel.enteringIn(guest, guestId);
                    System.out.println("Guest " + name + " entered successfully!");
                    break;
                case 3:
                    System.out.print("Enter guest name to exit: ");
                    String guestName = scanner.nextLine();
                    GuestRecord guestToExit = hotel.findGuestByName(guestName);
                    if (guestToExit != null) {
                        System.out.println("Guest " + guestName + " successfully exited.");
                        hotel.exit(guestToExit);
                    } else {
                        System.out.println("Guest " + guestName + " not found in records.");
                    }
                    break;
                case 4:
                    hotel.displayRecords();
                    break;
                case 5:
                    hotel.mealCount();
                    break;
                case 6:
                    System.out.println("Exiting Hotel Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
