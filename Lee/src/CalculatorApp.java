import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CalculatorApp {
    private JFrame frame;
    private JTextField textField;
    private String operator;
    private double num1, num2, result;

    private static HashMap<String, String> users = new HashMap<>();

    public CalculatorApp() {
        frame = new JFrame("Calculator with Login");
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 50));
        textField.setEditable(false);
        textField.setBackground(Color.BLACK); 
        textField.setForeground(Color.GREEN);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.DARK_GRAY); 

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "DEL", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 27));
            button.setOpaque(true);
            button.setBorderPainted(false);

            if ("DEL".equals(text)) {
                button.setBackground(Color.RED);
                button.setForeground(Color.WHITE);
            } else if ("=".equals(text)) {
                button.setBackground(Color.GREEN);
                button.setForeground(Color.BLACK);
            } else if ("+".equals(text) || "-".equals(text) || "*".equals(text) || "/".equals(text)) {
                button.setBackground(Color.ORANGE);
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(Color.LIGHT_GRAY);
                button.setForeground(Color.BLACK);
            }

            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        LogoPanel logoPanel = new LogoPanel();
        logoPanel.setBackground(Color.LIGHT_GRAY); 

        frame.add(logoPanel, BorderLayout.NORTH);
        frame.add(textField, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.SOUTH);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showLoginOrRegisterDialog();

        frame.setVisible(true);
    }

    private void showLoginOrRegisterDialog() {
        String[] options = {"Login", "Register"};
        int choice = JOptionPane.showOptionDialog(
            frame,
            "Would you like to log in or register?",
            "Welcome",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );

        if (choice == 0) {
            login();
        } else if (choice == 1) {
            register();
        } else {
            System.exit(0); 
        }
    }

    private void register() {
        String username = JOptionPane.showInputDialog(frame, "Enter a new username:");
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Username cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            register();
            return;
        }

        if (users.containsKey(username)) {
            JOptionPane.showMessageDialog(frame, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
            register();
            return;
        }

        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(frame, passwordField, "Enter a new password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String password = new String(passwordField.getPassword());
            if (password.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                register();
                return;
            }
            users.put(username, password);
            JOptionPane.showMessageDialog(frame, "Registration successful! Please log in.");
            login();
        } else {
            System.exit(0); 
        }
    }

    private void login() {
        String username = JOptionPane.showInputDialog(frame, "Enter Username:");
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Username cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            login();
            return;
        }

        if (!users.containsKey(username)) {
            JOptionPane.showMessageDialog(frame, "User does not exist! Please register first.", "Error", JOptionPane.ERROR_MESSAGE);
            register();
            return;
        }

        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showConfirmDialog(frame, passwordField, "Enter Password:", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String password = new String(passwordField.getPassword());
            if (!users.get(username).equals(password)) {
                JOptionPane.showMessageDialog(frame, "Invalid password! Exiting...", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } else {
            System.exit(0); 
        }
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                textField.setText(textField.getText() + command);
            } else if (command.equals("DEL")) {
                String currentText = textField.getText();
                if (currentText.length() > 0) {
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (command.equals("=")) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            JOptionPane.showMessageDialog(frame, "Cannot divide by zero!");
                            return;
                        }
                        break;
                }
                textField.setText(String.valueOf(result));
            } else {
                if (!textField.getText().isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = command;
                    textField.setText("");
                }
            }
        }
    }

    
    private class LogoPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw a simple logo
            g.setColor(Color.BLUE);
            g.fillRect(10, 10, 50, 50); 
            g.setColor(Color.RED);
            g.fillOval(70, 10, 50, 50); 
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("CalcApp", 130, 40); 
        }
    }

    public static void main(String[] args) {
        new CalculatorApp();
    }
}
