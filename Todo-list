import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ToDoList {
    // HashMap to store registered users (username -> password)
    private static HashMap<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        showLoginWindow();
    }

    public static void showLoginWindow() {
        JFrame loginFrame = new JFrame("ENDUERANCE WORKOUT");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 250);
        loginFrame.setLayout(new BorderLayout());
        loginFrame.setLocationRelativeTo(null);

        Color background = new Color(176, 224, 230);
        Color buttonColor = new Color(60, 179, 113);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        loginPanel.setBackground(background);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(buttonColor);
        loginButton.setForeground(Color.WHITE);
        JButton registerButton = new JButton("Register");
        registerButton.setBackground(buttonColor);
        registerButton.setForeground(Color.WHITE);

        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        loginFrame.add(loginPanel, BorderLayout.CENTER);
        loginFrame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());

                if (users.containsKey(username) && users.get(username).equals(password)) {
                    loginFrame.dispose();
                    showToDoListWindow();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ActionListener for the Register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRegistrationWindow();
            }
        });
    }

    public static void showRegistrationWindow() {
        JFrame registerFrame = new JFrame("Register");
        registerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerFrame.setSize(400, 250);
        registerFrame.setLocationRelativeTo(null);

        Color background = new Color(176, 224, 230);
        Color buttonColor = new Color(60, 179, 113);

        JPanel registerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        registerPanel.setBackground(background);

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("Register");
        registerButton.setBackground(buttonColor);
        registerButton.setForeground(Color.WHITE);

        registerPanel.add(usernameLabel);
        registerPanel.add(usernameField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(new JLabel()); // Empty label to align the button
        registerPanel.add(registerButton);

        registerFrame.add(registerPanel, BorderLayout.CENTER);
        registerFrame.setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword());

                if (!username.isEmpty() && !password.isEmpty()) {
                    if (users.containsKey(username)) {
                        JOptionPane.showMessageDialog(registerFrame, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        users.put(username, password);
                        JOptionPane.showMessageDialog(registerFrame, "Registration successful! Please log in.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        registerFrame.dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(registerFrame, "Username and Password cannot be empty!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void showToDoListWindow() {
        JFrame frame = new JFrame("Weekly Tasks");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(new BorderLayout());
    
        Color background = new Color(176, 224, 230);
        Color buttonColor = new Color(60, 179, 113);
        Color fontColor = new Color(0, 77, 64);
    
        JLabel titleLabel = new JLabel("Your To-do List", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(fontColor);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(background);
    
        DefaultListModel<String> taskList = new DefaultListModel<>();
        JList<String> list = new JList<>(taskList);
        list.setFont(new Font("Arial", Font.PLAIN, 16));
        list.setBackground(background);
        JScrollPane scrollPane = new JScrollPane(list);
    
        String[][] weeklyTasks = {
            {"Dumbell Bench Press 3x15", "Incline Bench Press 3x15", "Incline Barbell 3x15 ", "Lying Kick Backs 3x15", "Single Arm Extension 3x15",},  // Monday
            {"Barbel Upright Row 3x12 ", "Barbell Front Raise 3x15 ", "Barbell Seated Overhead Press 3x15", "Dumbell alternate Biceps Curl 3x15", "Dumbell Biceps Curl 3x15", "Dumbell Revers Biceps Curl 3x15"},  // Tuesday
            {"Squat 3x10", "jumping jacks 3x10", "Crunches 2x10", "High plank Legs 3x10", ""},  // Wednesday
            {"Normal Push-up 3x10", "Triangle push-ups 3x10", "Close Grip Bench Press 3x15", "Bent-Over Row 3x10", "Deadlift 3x15", "Seated Cable Rows 2x10"},  // Thursday
            {"Jumping Jacks 3x10", "Jump Rope 3x10", "Walking 5-Mins", "Running 3km", "Hiking", "High Knee 2x10"}, // Friday
            {"Diamond Push-Up 10x3", "Wide Push-up 2x10", "Spider Push-up 2x15", "Close Push-up 3x10", "Normal Push-up 3x10", "Lower hold Push-up 1 min"},  // Saturday
            {"SLEEP 8HRS EVERYDAY" }, // Sunday
        };
    
        JComboBox<String> daySelector = new JComboBox<>(new String[]{"Monday: CHEST & TRICEPS", "Tuesday: SHOULDER & BICEP", "Wednesday: LEGS & ABS", "Thursday: BACK & CHEST", "Friday: CARDIO", "Saturday: CIRCUIT EXERCISE", "Sunday: REST DAY!"});
        daySelector.setFont(new Font("Arial Black", Font.PLAIN, 16));
        daySelector.setBackground(buttonColor);
        daySelector.setForeground(Color.WHITE);
    
        daySelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dayIndex = daySelector.getSelectedIndex();
                taskList.clear();
                for (String task : weeklyTasks[dayIndex]) {
                    taskList.addElement(task);
                }
            }
        });
    
        JPanel inputPanel = new JPanel(new BorderLayout());
        JTextField taskField = new JTextField();
        JButton addButton = new JButton("➕ Add Task");
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.WHITE);
    
        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
    
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton removeButton = new JButton("🗑️ Remove Selected Task");
        removeButton.setBackground(new Color(220, 20, 60));
        removeButton.setForeground(Color.WHITE);
    
        JButton addToWeeklyButton = new JButton("📅 Add to Weekly Tasks");
        addToWeeklyButton.setBackground(buttonColor);
        addToWeeklyButton.setForeground(Color.WHITE);
    
        bottomPanel.add(removeButton);
        bottomPanel.add(addToWeeklyButton);
    
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    taskList.addElement(task);
                    taskField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Task cannot be empty!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskList.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(frame, "No task selected to remove!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    
        addToWeeklyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = JOptionPane.showInputDialog(frame, "Enter a new workout task:");
                if (task != null && !task.trim().isEmpty()) {
                    int dayIndex = daySelector.getSelectedIndex();
                    String[] updatedTasks = new String[weeklyTasks[dayIndex].length + 1];
                    System.arraycopy(weeklyTasks[dayIndex], 0, updatedTasks, 0, weeklyTasks[dayIndex].length);
                    updatedTasks[weeklyTasks[dayIndex].length] = task;
                    weeklyTasks[dayIndex] = updatedTasks;
    
                    taskList.addElement(task); // Update visible task list immediately
                } else {
                    JOptionPane.showMessageDialog(frame, "Task cannot be empty!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    
        frame.add(titleLabel, BorderLayout.NORTH);
        frame.add(daySelector, BorderLayout.PAGE_START);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);
        frame.add(bottomPanel, BorderLayout.PAGE_END);
    
        daySelector.setSelectedIndex(0); // Default to Monday
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}   
    
