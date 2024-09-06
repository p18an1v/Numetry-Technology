import java.util.ArrayList;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        createStudent createStud = new createStudent();
        displayStudent displayStud = new displayStudent();
        studentUpdate updater = new studentUpdate();
        studentDelete deleter = new studentDelete();

        ArrayList<Student> studList = new ArrayList<>();

        while (true) {
            System.out.println("----------------------");
            System.out.println("Choose an option:");
            System.out.println("1. Create Students");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    studList.addAll(createStud.create());
                    break;
                case 2:
                    displayStud.display(studList);
                    break;
                case 3:
                    System.out.println("Enter the ID of the student to update:");
                    int idToUpdate = sc.nextInt();

                    boolean found = false;
                    for (Student student : studList) {
                        if (student.getStudId() == idToUpdate) {
                            found = true;

                            System.out.println("Enter new name:");
                            String newName = sc.next();

                            System.out.println("Enter new address:");
                            String newAddress = sc.next();

                            System.out.println("Enter new contact:");
                            long newContact = sc.nextLong();

                            updater.update(student, newName, newAddress, newContact);
                            System.out.println("Student updated successfully!");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student with ID " + idToUpdate + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter the index of the student to delete:");
                    int indexToDelete = sc.nextInt();
                    deleter.deleteById(studList, indexToDelete);
                    System.out.println("Student deleted successfully!");
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
