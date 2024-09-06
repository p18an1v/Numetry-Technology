import java.util.Scanner;

public class CurrencyConverter {

    public static double convert(String strFrom, String strTo, double totalAmt) {
        // Dummy conversion rates
        double usdToInr = 74.5;
        double usdToCad = 1.25;
        double usdToEuro = 0.85;
        double usdToYen = 110.5;
        double usdToGbp = 0.75;

        // Convert input and output currency names to uppercase
        strFrom = strFrom.toUpperCase();
        strTo = strTo.toUpperCase();

        // Convert from input currency to target currency
        if (strFrom.equals("USD")) {
            if (strTo.equals("INR")) {
                return totalAmt * usdToInr;
            } else if (strTo.equals("DOLLAR")) {
                return totalAmt * usdToCad;
            } else if (strTo.equals("EURO")) {
                return totalAmt * usdToEuro;
            } else if (strTo.equals("YEN")) {
                return totalAmt * usdToYen;
            } else if (strTo.equals("POUNDS")) {
                return totalAmt * usdToGbp;
            }
        } else if (strFrom.equals("INR")) {
            if (strTo.equals("USD")) {
                return totalAmt / usdToInr;
            } else if (strTo.equals("DOLLAR")) {
                return (totalAmt / usdToInr) * usdToCad;
            } else if (strTo.equals("EURO")) {
                return (totalAmt / usdToInr) * usdToEuro;
            } else if (strTo.equals("YEN")) {
                return (totalAmt / usdToInr) * usdToYen;
            } else if (strTo.equals("POUNDS")) {
                return (totalAmt / usdToInr) * usdToGbp;
            }
        } else if (strFrom.equals("DOLLAR")) {
            if (strTo.equals("USD")) {
                return totalAmt / usdToCad;
            } else if (strTo.equals("INR")) {
                return (totalAmt / usdToCad) * usdToInr;
            } else if (strTo.equals("EURO")) {
                return (totalAmt / usdToCad) * usdToEuro;
            } else if (strTo.equals("YEN")) {
                return (totalAmt / usdToCad) * usdToYen;
            } else if (strTo.equals("POUNDS")) {
                return (totalAmt / usdToCad) * usdToGbp;
            }
        } else if (strFrom.equals("YEN")) {
            if (strTo.equals("USD")) {
                return totalAmt / usdToYen;
            } else if (strTo.equals("INR")) {
                return (totalAmt / usdToYen) * usdToInr;
            } else if (strTo.equals("DOLLAR")) {
                return (totalAmt / usdToYen) * usdToCad;
            } else if (strTo.equals("EURO")) {
                return (totalAmt / usdToYen) * usdToEuro;
            } else if (strTo.equals("POUNDS")) {
                return (totalAmt / usdToYen) * usdToGbp;
            }
        } else if (strFrom.equals("POUNDS")) {
            if (strTo.equals("USD")) {
                return totalAmt / usdToGbp;
            } else if (strTo.equals("INR")) {
                return (totalAmt / usdToGbp) * usdToInr;
            } else if (strTo.equals("DOLLAR")) {
                return (totalAmt / usdToGbp) * usdToCad;
            } else if (strTo.equals("EURO")) {
                return (totalAmt / usdToGbp) * usdToEuro;
            } else if (strTo.equals("YEN")) {
                return (totalAmt / usdToGbp) * usdToYen;
            }
        }
        System.out.println("Conversion from " + strFrom + " to " + strTo + " not supported.");
        return 0.0;
        
    }

}
