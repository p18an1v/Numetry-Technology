package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String driver="oracle.jdbc.OracleDriver";
    private static String url="jdbc:oracle:thin:@localhost:1521:XE";
    private static String username="system";
    private static String password="root";

    public static Connection getDbConnection()
    {
        Connection con=null;
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


    /*CREATE TABLE Users (
  2      userId NUMBER(10) PRIMARY KEY,
  3      userName VARCHAR2(255) NOT NULL,
  4      mobNumber NUMBER(19, 0) NOT NULL,
  5      balance FLOAT NOT NULL,
  6      password VARCHAR2(255) NOT NULL
  7  );



 -- Recreate the Passengers table
SQL> CREATE TABLE Passengers (
  2      passengerId NUMBER(10) PRIMARY KEY,
  3      ticketId NUMBER(10),
  4      passengerName VARCHAR2(255) NOT NULL,
  5      passengerMobNumber NUMBER(19, 0) NOT NULL,
  6      seatNumber NUMBER(10) NOT NULL,
  7      CONSTRAINT fk_ticketId FOREIGN KEY (ticketId) REFERENCES Tickets(ticketId)
  8  );


Recreate the Trains table
SQL> CREATE TABLE Trains (
  2      trainId NUMBER(10) PRIMARY KEY,
  3      pickUp VARCHAR2(255) NOT NULL,
  4      destination VARCHAR2(255) NOT NULL,
  5      express VARCHAR2(255) NOT NULL,
  6      trainNumber NUMBER(10) NOT NULL,
  7      price FLOAT NOT NULL
  8  );

*/
}


