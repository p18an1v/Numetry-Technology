import java.util.ArrayList;
import java.util.Scanner;

public class createStudent {
    public static ArrayList<Student> create() {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many students do you want to create?");
        int n = sc.nextInt();

        ArrayList<Student> studList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Student Id for student " + (i + 1) + ":");
            int studId = sc.nextInt();

            System.out.println("Enter Student Name for student " +":");
            String studName = sc.next();

            System.out.println("Enter Student Address for student " +":");
            String studAddress = sc.next();

            System.out.print("Enter Student Contact for student " +":");
            long studContact = sc.nextLong();

            studList.add(new Student(studId, studName, studAddress, studContact));
        }
        return studList;
    }
}
