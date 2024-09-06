package setUp;
import DB.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class paymentGateWay {
    public static void processPayment(int userId, String password, float ticketPrice) {
        // Retrieve user's balance from the database
        float userBalance = getUserBalance(userId, password);

        // Check if the user's balance is sufficient
        if (userBalance >= ticketPrice) {
            // Deduct the ticket price from the user's balance
            float newBalance = userBalance - ticketPrice;

            // Update the user's balance in the database
            updateUserBalance(userId, password, newBalance);

            System.out.println("Payment successful. Ticket price deducted from user's balance.");
        } else {
            System.out.println("Insufficient funds. Payment failed.");
        }
    }

    private static float getUserBalance(int userId, String password) {
        Connection con = DbConnection.getDbConnection();
        float balance = 0;

        try {
            PreparedStatement pstate = con.prepareStatement("SELECT balance FROM Users WHERE userId = ? AND password = ?");
            pstate.setInt(1, userId);
            pstate.setString(2, password);
            ResultSet rs = pstate.executeQuery();
            if (rs.next()) {
                balance = rs.getFloat("balance");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return balance;
    }

    private static void updateUserBalance(int userId, String password, float newBalance) {
        Connection con = DbConnection.getDbConnection();

        try {
            PreparedStatement pstate = con.prepareStatement("UPDATE Users SET balance = ? WHERE userId = ? AND password = ?");
            pstate.setFloat(1, newBalance);
            pstate.setInt(2, userId);
            pstate.setString(3, password);
            pstate.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
