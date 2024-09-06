public class MainMethode {
    
   
        public static void main(String[] args) {
            // Example usage of DbOperations class
            dbOprations dbOperations = new dbOprations();
    
            // Insert a new student
            dbOperations.create(1, "John Doe");
    
            // Display all students
            System.out.println("List of Students:");
            dbOperations.display();
        }
    
}
