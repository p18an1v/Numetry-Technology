import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

class AuthenticationService {
    private Map<String, User> users;

    public AuthenticationService() {
        this.users = new HashMap<>();
    }

    public void register(String username, String password, String role) {
        if (users.containsKey(username.toLowerCase())) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }
        User user = new User(username, password, role);
        users.put(username.toLowerCase(), user);
        System.out.println("User registered successfully " + username + " for "+ " (" + role + ").");
    }

    public boolean login(String username, String password) {
        User user = users.get(username.toLowerCase());
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful! Welcome " + username);
            return true;
        }
        System.out.println("Invalid username or password.");
        return false;
    }

    public void changePassword(String username, String oldPassword, String newPassword) {
        User user = users.get(username.toLowerCase());
        if (user != null && user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void deleteUser(String adminUsername, String targetUsername) {
        User adminUser = users.get(adminUsername.toLowerCase());
        User targetUser = users.get(targetUsername.toLowerCase());

        if (adminUser != null && adminUser.getRole().equalsIgnoreCase("Admin")) {
            if (targetUser != null && !targetUser.getRole().equalsIgnoreCase("Admin")) {
                users.remove(targetUsername.toLowerCase());
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("Cannot delete admin user or user not found.");
            }
        } else {
            System.out.println("Only admins can delete users.");
        }
    }

    public void updateUserRole(String adminUsername, String targetUsername, String newRole) {
        User adminUser = users.get(adminUsername.toLowerCase());
        User targetUser = users.get(targetUsername.toLowerCase());

        if (adminUser != null && adminUser.getRole().equalsIgnoreCase("Admin")) {
            if (targetUser != null && !targetUser.getRole().equalsIgnoreCase("Admin")) {
                targetUser.setRole(newRole);
                System.out.println("User role updated successfully!");
            } else {
                System.out.println("Cannot update admin user role or user not found.");
            }
        } else {
            System.out.println("Only admins can update user roles.");
        }
    }

    public String getUserRole(String username) {
        User user = users.get(username.toLowerCase());
        return (user != null) ? user.getRole() : null;
    }
}

public class LoginMain {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Login System");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String newPassword = scanner.nextLine();
                    System.out.println("Select role:");
                    System.out.println("1. Admin");
                    System.out.println("2. Manager");
                    System.out.println("3. Staff");
                    System.out.println("4. Employee");
                    System.out.print("Enter role number: ");
                    int roleChoice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    String newRole;
                    switch (roleChoice) {
                        case 1:
                            newRole = "Admin";
                            break;
                        case 2:
                            newRole = "Manager";
                            break;
                        case 3:
                            newRole = "Staff";
                            break;
                        case 4:
                            newRole = "Employee";
                            break;
                        default:
                        System.out.println("Invalid role choice. Defaulting to Employee.");
                        newRole = "Employee";
                }
                authService.register(newUsername, newPassword, newRole);
                break;
            case 2:
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                if (authService.login(username, password)) {
                    String role = authService.getUserRole(username);
                    if (role != null && role.equalsIgnoreCase("Admin")) {
                        System.out.println("Admin options:");
                        System.out.println("1. Delete User");
                        System.out.println("2. Update User Role");
                        System.out.print("Enter option number: ");
                        int adminOption = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline

                        switch (adminOption) {
                            case 1:
                                System.out.print("Enter username to delete: ");
                                String targetUsername = scanner.nextLine();
                                authService.deleteUser(username, targetUsername);
                                break;
                            case 2:
                                System.out.print("Enter username to update role: ");
                                targetUsername = scanner.nextLine();
                                System.out.print("Enter new role: ");
                                String newRoleUpdate = scanner.nextLine();
                                authService.updateUserRole(username, targetUsername, newRoleUpdate);
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                }
                break;
            case 3:
                System.out.println("Exiting the system. Goodbye!");
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
}


