import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class dbOprations {

    Connection con;
    PreparedStatement ps;
    public void create(int studId, String studName){
        try {
            con = dbConnect.getDbConnection();
            ps = con.prepareStatement("INSERT INTO student(studId, studName) VALUES (?, ?)");
            ps.setInt(1, studId);
            ps.setString(2, studName);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    public void display(){
           try {
            con = dbConnect.getDbConnection();
            ps = con.prepareStatement("select * from  student");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("studId") + ", Name: " + rs.getString("StudName"));
            }

           } catch (Exception e) {
            e.printStackTrace();
           }
        
    }
}
