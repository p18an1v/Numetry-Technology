import java.awt.*;
import java.util.Scanner;

import static setUp.createLogin.createUser;
import static setUp.createLogin.login;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Welcome to railway reservation");
        System.out.println("--------------------------------");
        System.out.println("Enter your choice : ");
        System.out.println("1. Create User");
        System.out.println("2. Login");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                createUser();
                break;
            case 2:
                login();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}