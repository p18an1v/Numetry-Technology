import java.util.Scanner;

public class mainMethod {

    public static void main(String[] args) {
        String str;
        do {
            System.out.println("____________Welcome to Currency Converter__________");
            Scanner sc = new Scanner(System.in);
            System.out.println("USD | Rupee | Canadian Dollar | Euro | Japanese Yen | British Pounds");
            System.out.println("Enter the currency to convert from: ");
            String strFrom = sc.next();
            if (!isValidCurrency(strFrom)) {
                System.out.println("Invalid currency input.");
                return; // Exit the program
            }

            System.out.println("Enter Amount");
            double totalAmt = sc.nextDouble();

            System.out.println("Enter the currency to convert to: ");
            String strTo = sc.next();
            if (!isValidCurrency(strTo)) {
                System.out.println("Invalid currency input.");
                return; // Exit the program
            }

            double convertedAmount = CurrencyConverter.convert(strFrom, strTo, totalAmt);
            if (convertedAmount == 0.0) {
                System.out.println("Conversion to " + strTo + " not supported.");
                return; // Exit the program
            }

            System.out.println("Converted amount from " + strFrom + " to " + strTo + " is: " + convertedAmount);

            System.out.println("Do you want to Continue? Type YES/NO");
            str = sc.next();
        } while (str.equalsIgnoreCase("YES"));
    }

    // Method to validate currency input
    public static boolean isValidCurrency(String currency) {
        return currency.equalsIgnoreCase("USD") || currency.equalsIgnoreCase("INR") ||
                currency.equalsIgnoreCase("Dollar") || currency.equalsIgnoreCase("Euro") ||
                currency.equalsIgnoreCase("Yen") || currency.equalsIgnoreCase("Pounds");
    }
}