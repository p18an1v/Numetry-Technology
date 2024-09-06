import java.util.ArrayList;

public class studentDelete {
    
     public void deleteById(ArrayList<Student> students, int idToDelete) {
        for (Student student : students) {
            if (student.getStudId() == idToDelete) {
                students.remove(student);
                System.out.println("Student with ID " + idToDelete + " deleted successfully.");
                return; // Exit the loop once the student is found and deleted
            }
        }
        System.out.println("Student with ID " + idToDelete + " not found.");
    }
}
