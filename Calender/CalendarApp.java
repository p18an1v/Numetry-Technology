import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CalendarApp extends JFrame {
    private JLabel lblMonth;
    private JLabel lblDateTime;
    private JPanel calendarPanel;
    private JButton btnPrevMonth;
    private JButton btnNextMonth;
    private JButton btnApplyLeave;
    private JButton btnShowEvents;
    private int currentYear;
    private int currentMonth;
    private java.util.List<Event> events;

    public CalendarApp() {
        setTitle("Calendar App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        LocalDate currentDate = LocalDate.now();
        currentYear = currentDate.getYear();
        currentMonth = currentDate.getMonthValue();

        btnPrevMonth = new JButton("<< Prev Month");
        btnNextMonth = new JButton("Next Month >>");
        btnApplyLeave = new JButton("Apply for Leave");
        btnShowEvents = new JButton("Show Events");

        lblMonth = new JLabel();
        lblMonth.setHorizontalAlignment(SwingConstants.CENTER);

        lblDateTime = new JLabel();
        lblDateTime.setHorizontalAlignment(SwingConstants.CENTER);

        calendarPanel = new JPanel(new GridLayout(0, 7));
        add(calendarPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.add(btnPrevMonth);
        controlPanel.add(lblMonth);
        controlPanel.add(btnNextMonth);
        controlPanel.add(lblDateTime);
        controlPanel.add(btnApplyLeave);
        controlPanel.add(btnShowEvents);

        add(controlPanel, BorderLayout.NORTH);

        events = new ArrayList<>();

        btnPrevMonth.addActionListener(e -> {
            currentMonth--;
            if (currentMonth < 1) {
                currentMonth = 12;
                currentYear--;
            }
            refreshCalendar();
        });

        btnNextMonth.addActionListener(e -> {
            currentMonth++;
            if (currentMonth > 12) {
                currentMonth = 1;
                currentYear++;
            }
            refreshCalendar();
        });

        btnApplyLeave.addActionListener(e -> {
            new LeaveApplicationDialog(this, currentYear, currentMonth);
        });

        btnShowEvents.addActionListener(e -> {
            showEventsForMonth(currentMonth, currentYear);
        });

        Timer timer = new Timer(1000, e -> lblDateTime.setText(getDateTimeString()));
        timer.setInitialDelay(0);
        timer.start();

        refreshCalendar();

        setVisible(true);
    }

    private void refreshCalendar() {
        String monthName = YearMonth.of(currentYear, currentMonth).getMonth().toString();
        lblMonth.setText(monthName.toUpperCase() + " " + currentYear);

        calendarPanel.removeAll();

        LocalDate firstDayOfMonth = LocalDate.of(currentYear, currentMonth, 1);
        int startDay = firstDayOfMonth.getDayOfWeek().getValue();

        for (int i = 1; i < startDay; i++) {
            calendarPanel.add(new JLabel(""));
        }

        for (int day = 1; day <= YearMonth.of(currentYear, currentMonth).lengthOfMonth(); day++) {
            JLabel label = new JLabel(String.valueOf(day));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            int finalDay = day;
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showEvents(finalDay);
                }
            });
            calendarPanel.add(label);
        }

        revalidate();
        repaint();
    }

    private void showEvents(int day) {
        LocalDate selectedDate = LocalDate.of(currentYear, currentMonth, day);
        String[] options = {"Set Reminder", "Set Birthday", "Apply for Leave", "Cancel"};
        int choice = JOptionPane.showOptionDialog(this,
                "Select an option for " + selectedDate,
                "Event Options",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[3]);

        switch (choice) {
            case 0: // Set Reminder
                String reminderText = JOptionPane.showInputDialog(this, "Enter reminder message:");
                if (reminderText != null && !reminderText.isEmpty()) {
                    Event reminderEvent = new Event("Reminder: " + reminderText, selectedDate);
                    addEvent(reminderEvent);
                }
                break;
            case 1: // Set Birthday
                String birthdayPerson = JOptionPane.showInputDialog(this, "Enter the name for the birthday:");
                if (birthdayPerson != null && !birthdayPerson.isEmpty()) {
                    Event birthdayEvent = new Event("Birthday: " + birthdayPerson, selectedDate);
                    addEvent(birthdayEvent);
                }
                break;
            case 2: // Apply for Leave
                new LeaveApplicationDialog(this, currentYear, currentMonth);
                break;
            default:
                // Cancel or close the dialog
                break;
        }
    }

    private String getDateTimeString() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String dateString = currentDate.format(dateFormatter);
        String timeString = java.time.LocalTime.now().format(timeFormatter);
        return dateString + " " + timeString;
    }

    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Event Added: " + event.getTitle() + " on " + event.getDate());
    }

    private void showEventsForMonth(int month, int year) {

        System.out.println("-----------------------------------------------------");
        System.out.println("ALL EVENTS");
        for (Event event : events) {
            if (event.getDate().getMonthValue() == month && event.getDate().getYear() == year) {
                System.out.println(event.getTitle() + " on " + event.getDate());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CalendarApp::new);
    }
}

class Event {
    private String title;
    private LocalDate date;

    public Event(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }
}

// Custom dialog for leave application
class LeaveApplicationDialog extends JDialog {
    private JComboBox<Integer> dayComboBox;
    private JTextField reasonField;

    public LeaveApplicationDialog(Frame parent, int year, int month) {
        super(parent, "Apply for Leave", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Day:"));
        dayComboBox = new JComboBox<>();
        for (int day = 1; day <= YearMonth.of(year, month).lengthOfMonth(); day++) {
            dayComboBox.addItem(day);
        }
        panel.add(dayComboBox);

        panel.add(new JLabel("Reason:"));
        reasonField = new JTextField();
        panel.add(reasonField);

        JButton applyButton = new JButton("Apply");
        applyButton.addActionListener(e -> {
            applyLeave(year, month, (int) dayComboBox.getSelectedItem(), reasonField.getText());
            dispose();
        });
        panel.add(applyButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());
        panel.add(cancelButton);

        add(panel);
        setVisible(true);
    }

    private void applyLeave(int year, int month, int day, String reason) {
        LocalDate leaveDate = LocalDate.of(year, month, day);
        JOptionPane.showMessageDialog(this, "Leave applied for: " + leaveDate + "\nReason: " + reason);
        CalendarApp app = (CalendarApp) this.getParent();
        Event leaveEvent = new Event("Leave: " + reason, leaveDate);
        app.addEvent(leaveEvent);
    }
}

