import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, User> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to Notes Taking System!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static int getIntInput() {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                break;
            } else {
                scanner.next();
            }
        }
        return choice;
    }


    private static void registerUser() {
        System.out.println("\n*** Register ***");
        System.out.print("Enter username: ");
        String username = scanner.next();
        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.next();
        users.put(username, new User(username, password));
        System.out.println("User registered successfully!");
    }

    private static void loginUser() {
        System.out.println("\n*** Login ***");
        System.out.print("Enter username: ");
        String username = scanner.next();
        User user = users.get(username);
        if (user != null) {
            if (authenticateUser(user)) {
                System.out.println("Login successful!");
                showNoteOptions(user);
            } else {
                System.out.println("Invalid password!");
            }
        } else {
            System.out.println("User not found!");
        }
    }

    private static boolean authenticateUser(User user) {
        System.out.print("Enter password: ");
        String password = scanner.next();
        return user.getPassword().equals(password);
    }

    private static void showNoteOptions(User user) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n1. View Notes");
            System.out.println("2. Add Note");
            System.out.println("3. Update Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    viewNotes(user);
                    break;
                case 2:
                    addNote(user);
                    break;
                case 3:
                    updateNote(user);
                    break;
                case 4:
                    deleteNote(user);
                    break;
                case 5:
                    loggedIn = false;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void viewNotes(User user) {
        if (user.getNotes().isEmpty()) {
            System.out.println("No notes available!");
        } else {
            System.out.println("\n*** Your Notes ***");
            for (Note note : user.getNotes().values()) {
                String combinedData = note.getCombinedData();
                String[] parts = combinedData.split(":-", 2);
                if (parts.length == 2) {
                    System.out.println("ID: " + note.getId());
                    System.out.println("Header: " + parts[0].trim());
                    System.out.println("Content: " + parts[1].trim());
                    System.out.println();
                } else {
                    System.out.println("Invalid note format: " + combinedData);
                }
            }
        }
    }




    private static void addNote(User user) {
        if (authenticateUser(user)) {
            System.out.print("Enter note heading: ");
            scanner.nextLine(); // Consume newline character
            String heading = scanner.nextLine().trim(); // Read heading
            System.out.println("Enter note content. Enter '###' on a new line to finish:");

            StringBuilder contentBuilder = new StringBuilder();
            String line;
            while (!(line = scanner.nextLine().trim()).equals("###")) {
                contentBuilder.append(line).append("\n"); // Append line to content
            }
            String content = contentBuilder.toString().trim(); // Trim leading/trailing whitespace

            String combinedData = heading + ":-" + content; // Combine heading and content with delimiter
            int id = user.getNotes().size() + 1; // generate unique id
            user.getNotes().put(id, new Note(id, combinedData));
            System.out.println("Note added successfully!");
        } else {
            System.out.println("Authentication failed. Cannot add note.");
        }
    }

    private static void updateNote(User user) {
        if (authenticateUser(user)) {
            System.out.print("Enter note ID to update: ");
            int id = getIntInput();
            if (user.getNotes().containsKey(id)) {
                System.out.print("Enter new header and content (separated by ':-'): ");
                scanner.nextLine(); // Consume newline character
                String combinedData = scanner.nextLine().trim(); // Read combined data
                user.getNotes().get(id).setCombinedData(combinedData);
                System.out.println("Note updated successfully!");
            } else {
                System.out.println("Note with ID " + id + " not found!");
            }
        } else {
            System.out.println("Authentication failed. Cannot update note.");
        }
    }


    private static void deleteNote(User user) {
        if (authenticateUser(user)) {
            System.out.print("Enter note ID to delete: ");
            int id = getIntInput();
            if (user.getNotes().containsKey(id)) {
                user.getNotes().remove(id);
                System.out.println("Note deleted successfully!");
            } else {
                System.out.println("Note with ID " + id + " not found!");
            }
        } else {
            System.out.println("Authentication failed. Cannot delete note.");
        }
    }
}