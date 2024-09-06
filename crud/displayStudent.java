import java.util.ArrayList;

public class displayStudent {

    public void display(ArrayList<Student> stud) {
        for (Student student : stud) {
            System.out.println("-----------------------");
            System.out.println("Student Name: " + student.getStudName());
            System.out.println("Student Id: " + student.getStudId());
            System.out.println("Student Address: " + student.getStudAddress());
            System.out.println("Student Contact: " + student.getStudContact());
        }
    }

}
