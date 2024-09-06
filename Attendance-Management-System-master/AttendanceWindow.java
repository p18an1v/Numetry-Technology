import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JTextField;

public class AttendanceWindow extends JFrame {

    public AttendanceWindow() {
        setTitle("Mark Attendance");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel nameLabel = new JLabel("Student Name:");
        JTextField nameField = new JTextField(20);

        JLabel subjectLabel = new JLabel("Subject:");
        JComboBox<String> subjectComboBox = new JComboBox<>();
        subjectComboBox.addItem("Math");
        subjectComboBox.addItem("Science");
        subjectComboBox.addItem("History");
        // Add more subjects as needed

        JLabel timeLabel = new JLabel("Time:");
        SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(spinnerDateModel);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);

        JButton markButton = new JButton("Mark Attendance");
        markButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String subject = (String) subjectComboBox.getSelectedItem();
                String time = new SimpleDateFormat("HH:mm").format((Date) timeSpinner.getValue());

                // Perform attendance marking logic here

                String message = "Attendance marked for:\nName: " + name + "\nSubject: " + subject + "\nTime: " + time;
                JOptionPane.showMessageDialog(AttendanceWindow.this, message);
                saveAttendanceToFile(name, subject, time);
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                // Add code here to navigate back to the previous window
                // For example, if the previous window is 'StudLin', you can create an instance of it and make it visible
                StudLin previousWindow = new StudLin();
                previousWindow.setSize(600, 400);
                previousWindow.setLocationRelativeTo(null);
                previousWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Adjust this according to your application
                previousWindow.setVisible(true);
            }
        });

        panel.add(nameLabel, gbc);
        panel.add(nameField, gbc);
        panel.add(subjectLabel, gbc);
        panel.add(subjectComboBox, gbc);
        panel.add(timeLabel, gbc);
        panel.add(timeSpinner, gbc);
        panel.add(markButton, gbc);
        panel.add(backButton, gbc); // Add the "Back" button

        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void saveAttendanceToFile(String name, String subject, String time) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\vishw\\OneDrive\\Documents\\Desktop\\Numetry\\Attendance-Management-System-master\\.txt\\attendence.txt", true))) {
            writer.write("Name: " + name + ", Subject: " + subject + ", Time: " + time);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save attendance to file.");
        }
    }

    public static void main(String[] args) {
        new AttendanceWindow();
    }
}

