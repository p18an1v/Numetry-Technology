package DB;

import model.Login;
import model.Passenger;
import model.Train;
import model.User;

import java.sql.*;
import java.util.List;

public class dataBaseManeger {


    /*
    * select * from users
    * select * from passenger
    *
    * */

    //Create user
    public int create_db(List<User> userList) {
        Connection con = DbConnection.getDbConnection();
        int flag = 0;
        for (User user : userList) {
            try {
                PreparedStatement pstate = con.prepareStatement("INSERT INTO users VALUES ( ?, ?, ?, ?, ?)");
                pstate.setInt(1, user.getUserId());
                pstate.setString(2, user.getUserName());
                pstate.setLong(3, user.getMobNumber());
                pstate.setFloat(4, user.getBal());
                pstate.setString(5, user.getPswd());
                int i = pstate.executeUpdate();
                if (i > 0) {
                    System.out.println("Record Saved.");
                    flag = 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }


    //Login user
    public int search_db(Login login) {
        Connection con = DbConnection.getDbConnection();
        User acc;
        int i = 0;
        try {
            PreparedStatement pstate = con.prepareStatement("SELECT * FROM users WHERE mobNumber = ? AND password  = ?");
            pstate.setLong(1, login.getMobNumber());
            pstate.setString(2, login.getPswd());
            ResultSet rs = pstate.executeQuery();
            if (rs.next()) {
                acc = new User(rs.getInt("userId"), rs.getString("userName"), rs.getLong("mobNumber"), rs.getFloat("balance"), rs.getString("password"));
                i = 1;
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
        return i;
    }


    // Store passenger
    public static int storePassenger(Passenger passenger) {
        Connection connection = DbConnection.getDbConnection();
        int i = 0;
        try {
            String query = "INSERT INTO passenger (passName, mobNumber, seatNum) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, passenger.getPassName());
            statement.setLong(2, passenger.getMobNumber());
            statement.setInt(3, passenger.getSeatNum());

           i = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    // Store train
    /*
    public void storeTrain(Train train) {
        Connection connection = DbConnection.getDbConnection();
        try {
            String query = "INSERT INTO train (pickUp, desti, express, trainNumber, price) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, train.getPickUp());
            statement.setString(2, train.getDesti());
            statement.setString(3, train.getExpress());
            statement.setInt(4, train.getTrainNumber());
            statement.setFloat(5, train.getPrice());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    */

    // Display all
    public static void displayUser(Login login) {
        Connection connection = DbConnection.getDbConnection();
        try {
            String query = "SELECT * FROM users WHERE mobNumber = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, login.getMobNumber());
            preparedStatement.setString(2, login.getPswd());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String userName = resultSet.getString("userName");
                long mobNumber = resultSet.getLong("mobNumber");
                float balance = resultSet.getFloat("balance");
                String password = resultSet.getString("password");

                System.out.println("User Data :-");
                System.out.println("User Name: " + userName);
                System.out.println("Mobile Number: " + mobNumber);
                System.out.println("Balance: " + balance);
                System.out.println("Password: " + password);
            } else {
                System.out.println("User not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




}
