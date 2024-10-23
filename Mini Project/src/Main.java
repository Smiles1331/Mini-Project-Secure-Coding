import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class Main {
    // Store user credentials in a HashMap for simplicity
    private static HashMap<String, String> userDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Create the initial registration frame
        showRegistrationFrame();
    }

    private static void showRegistrationFrame() {
        JFrame frame = new JFrame("User Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel userLabel = new JLabel("Choose Username:");
        JTextField userText = new JTextField(15);
        JLabel passwordLabel = new JLabel("Choose Password:");
        JPasswordField passwordText = new JPasswordField(15);
        JButton registerButton = new JButton("Register");
        JLabel feedbackLabel = new JLabel("");

        // Register button action
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Simple validation
                if (!username.isEmpty() && !password.isEmpty()) {
                    userDatabase.put(username, password); // Store user credentials
                    feedbackLabel.setText("Registration successful! You can now log in.");
                    showLoginFrame();
                    frame.dispose();
                } else {
                    feedbackLabel.setText("Please fill in both fields.");
                }
            }
        });

        // Layout setup
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(userLabel, gbc);
        gbc.gridx = 1;
        frame.add(userText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passwordLabel, gbc);
        gbc.gridx = 1;
        frame.add(passwordText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(registerButton, gbc);
        gbc.gridy = 3;
        frame.add(feedbackLabel, gbc);

        frame.setVisible(true);
    }

    private static void showLoginFrame() {
        JFrame frame = new JFrame("User Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel userLabel = new JLabel("Enter Username:");
        JTextField userText = new JTextField(15);
        JLabel passwordLabel = new JLabel("Enter Password:");
        JPasswordField passwordText = new JPasswordField(15);
        JButton loginButton = new JButton("Sign In");
        JLabel feedbackLabel = new JLabel("");

        // Login button action
        loginButton .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                // Validate credentials
                if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
                    showWelcomeFrame(username);
                    frame.dispose();
                } else {
                    feedbackLabel.setText("Incorrect username or password. Please try again.");
                }
            }
        });

        // Layout setup
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(userLabel, gbc);
        gbc.gridx = 1;
        frame.add(userText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(passwordLabel, gbc);
        gbc.gridx = 1;
        frame.add(passwordText, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(loginButton, gbc);
        gbc.gridy = 3;
        frame.add(feedbackLabel, gbc);

        frame.setVisible(true);
    }

    private static void showWelcomeFrame(String username) {
        JFrame frame = new JFrame("Welcome, " + username);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        JLabel welcomeLabel = new JLabel("Welcome, " + username + " Your registration number is H230691H" + "!");

        // Layout setup
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(welcomeLabel, gbc);

        frame.setVisible(true);
    }
}