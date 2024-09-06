import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Hotel{
    LinkedList<GuestRecord> record = new LinkedList<>();
    ArrayList<Desks> desk = new ArrayList<>();
    static int breakfastCount;
    static int lunchCount;
    static int dinnerCount;

    public void setLimit() {
        for (int i = 0; i < 20; i++) {
            desk.add(new Desks());
        }
    }

    public int availableDesks() {
        int available = 0;
        for (Desks d : desk) {
            if (!d.isTaken()) {
                available++;
            }
        }
        return available;
    }

    public void enteringIn(GuestRecord guest, int guestId) {
        int i = 0;
        for (Desks desks : desk) {
            i++;
            if (!desks.isTaken()) {
                desks.setTaken(true);
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter Entry time of " + guest.getName() + ": ");
                String in = sc.nextLine();
                guest.setEntryTime(in);
                guest.setDeskNo(i);
                guest.setGuestId(guestId);
                
                String chooseMealType= chooseMealType(sc);
                guest.setMealType(chooseMealType);
    
                record.add(guest);
                return;
            }
        }
        System.out.println("No desk is available for Entry");
    }
    
    public String chooseMealType(Scanner scanner) {
        System.out.println("Choose meal type:");
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");
        System.out.print("Enter your choice (1-3): ");
    
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        switch (choice) {
            case 1:
                return "Breakfast";
            case 2:
                return "Lunch";
            case 3:
                return "Dinner";
            default:
                System.out.println("Invalid choice. Defaulting to Breakfast.");
                return "Breakfast";
        }
    }
    

    



    public void exit(GuestRecord guest) {
        int i = guest.getDeskNo();
        Desks deskAt = desk.get(i - 1);

        if (deskAt.isTaken()) {
            deskAt.setTaken(false);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Exit Time: ");
            String out = sc.nextLine();
            guest.setExitTime(out);
            int id = guest.getGuestId();
            record.set(id - 1, guest);
            return;
        }
        System.out.println("Desk is not taken by " + guest.getName());
    }

    public String foodCount(String mealType) {
        switch (mealType) {
            case "breakfast":
                breakfastCount++;
                break;
            case "lunch":
                lunchCount++;
                break;
            case "dinner":
                dinnerCount++;
                break;
        }
        return mealType;
    }

    public static void mealCount() {
        System.out.println("Breakfast: " + breakfastCount);
        System.out.println("Lunch: " + lunchCount);
        System.out.println("Dinner: " + dinnerCount);
    }

    public GuestRecord findGuestByName(String name) {
        for (GuestRecord guest : record) {
            if (guest.getName().equalsIgnoreCase(name)) {
                return guest;
            }
        }
        return null;
    }

    public void displayRecords() {
        for (GuestRecord guest : record) {
            System.out.println("Name: " + guest.getName());
            System.out.println("DeskNo: " + guest.getDeskNo());
            System.out.println("Entry time: " + guest.getEntryTime());
            System.out.println("Exit time: " + guest.getExitTime());
            System.out.println("Guest id: " + guest.getGuestId());
            System.out.println();
        }
    }

    
    
}

