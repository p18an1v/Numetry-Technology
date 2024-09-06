package setUp;

import DB.dataBaseManeger;
import model.Login;
import model.Passenger;
import model.User;

import java.sql.ResultSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static DB.dataBaseManeger.displayUser;

public class createLogin {


    private static Map<Integer, String> stationMap = new HashMap<>();
    private static Map<String, Map<String, Float>> priceMap = new HashMap<>();

    static {
        stationMap.put(1, "Pune");
        stationMap.put(2, "Mumbai");
        stationMap.put(3, "Thane");
        stationMap.put(4, "Sambhajinagar");

        Map<String, Float> punePrices = new HashMap<>();
        punePrices.put("Mumbai", 150.0f);
        punePrices.put("Thane", 120.0f);
        punePrices.put("Sambhajinagar", 100.0f);

        Map<String, Float> mumbaiPrices = new HashMap<>();
        mumbaiPrices.put("Pune", 90.0f);
        mumbaiPrices.put("Thane", 80.0f);
        mumbaiPrices.put("Sambhajinagar", 110.0f);

        Map<String, Float> thanePrices = new HashMap<>();
        thanePrices.put("Pune", 130.0f);
        thanePrices.put("Mumbai", 85.0f);
        thanePrices.put("Sambhajinagar", 95.0f);

        Map<String, Float> sambhajinagarPrices = new HashMap<>();
        sambhajinagarPrices.put("Pune", 95.0f);
        sambhajinagarPrices.put("Mumbai", 105.0f);
        sambhajinagarPrices.put("Thane", 100.0f);

        priceMap.put("Pune", punePrices);
        priceMap.put("Mumbai", mumbaiPrices);
        priceMap.put("Thane", thanePrices);
        priceMap.put("Sambhajinagar", sambhajinagarPrices);
    }

    public static void createUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter User Id : ");
        int userId = sc.nextInt();
        sc.nextLine();  // Consume the newline character

        System.out.println("Enter your name: ");
        String userName = sc.nextLine();

        System.out.println("Enter your mobile number: ");
        Long mobNumber = sc.nextLong();
        sc.nextLine(); // Consume the newline character

        System.out.println("Enter your balance: ");
        float bal = sc.nextFloat();
        sc.nextLine(); // Consume the newline character

        System.out.println("Enter your password: ");
        String pswd = sc.nextLine();


        User user = new User(userId,userName, mobNumber, bal, pswd);

        // Save the user to the database
        dataBaseManeger dbManager = new dataBaseManeger();
        int result = dbManager.create_db(Collections.singletonList(user));

        if (result == 1) {
            System.out.println("User created successfully");

            System.out.println("Redirected to login.. page");
            login();
        } else {
            System.out.println("Failed to create user");
        }
    }

    public static void login() {
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = false;
        System.out.println("Enter your mobile number: ");
        Long mobNumber = sc.nextLong();
        sc.nextLine(); // Consume the newline character

        System.out.println("Enter your password: ");
        String pswd = sc.nextLine();

        Login login = new Login(mobNumber, pswd);

        // Search for the user in the database
        dataBaseManeger dbManager = new dataBaseManeger();
        int result = dbManager.search_db(login);

        if (result == 1) {
            System.out.println("Login successful");

            do {
                System.out.println("--------------------------------");
                System.out.println("Welcome to login dashboard..");
                System.out.println("---------------------------------");
                System.out.println("Enter your Choice..");
                System.out.println("1]. Display Balance        2]. Book Ticket      3]. Exit");

                int choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        displayUserData();
                        break;
                    case 2:
                        bookTicket();
                        break;
                    case 3:
                        loggedIn = true; // Set loggedIn to true to exit the loop
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (!loggedIn);
        } else {
            System.out.println("Invalid mobile number or password");
        }
    }

    public static void bookTicket() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pickup point station choice");
        displayStationChoices();

        int pickupChoice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        System.out.println("Enter the destination point station choice");
        displayStationChoices();

        int destinationChoice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        String pickupStation = stationMap.get(pickupChoice);
        String destinationStation = stationMap.get(destinationChoice);

        float price = calculatePrice(pickupStation, destinationStation);
        createPassenger(pickupStation, destinationStation, price);
        System.out.println("Ticket from " + pickupStation + " to " + destinationStation);
        System.out.println("Price: " + price);

        System.out.println("Enter User Id and password to process the payment");
        int userid = sc.nextInt();
        sc.nextLine();
        String  password = sc.next();
        paymentGateWay.processPayment( userid,password,price);
    }


    public static void createPassenger(String pickupStation, String destinationStation, float price) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter passenger name: ");
        String passName = sc.nextLine();

        System.out.println("Enter passenger mobile number: ");
        Long mobNumber = sc.nextLong();
        sc.nextLine(); // Consume the newline character

        System.out.println("Enter seat number: ");
        int seatNum = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        Passenger passenger = new Passenger(passName, mobNumber, seatNum);
        int result = dataBaseManeger.storePassenger(passenger);



        if (result == 1) {
            System.out.println("Passenger Created.. successfully and stored in database");
            System.out.println("Your seat is reserved");
        } else {
            System.out.println("Passenger failed to store");
        }
    }

    public static void displayStationChoices() {
        for (Map.Entry<Integer, String> entry : stationMap.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    public static float calculatePrice(String pickupStation, String destinationStation) {
        return priceMap.get(pickupStation).get(destinationStation);
    }

    public static void displayUserData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the user Mob number : ");
        long userMob = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the User Password");
        String password = sc.next();

        Login login = new Login(userMob, password);
        displayUser(login);
        // Process the ResultSet as needed
    }
}
