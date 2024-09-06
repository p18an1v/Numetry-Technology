public class studentUpdate {

    public void update(Student student, String newName, String newAddress, long newContact) {
        if (student != null) {
            if (newName != null && !newName.isEmpty()) {
                student.setStudName(newName);
            }

            if (newAddress != null && !newAddress.isEmpty()) {
                student.setStudAddress(newAddress);
            }

            if (newContact > 0) {
                student.setStudContact(newContact);
            }
        } else {
            System.out.println("Invalid student object. Update failed.");
        }
    }
}
