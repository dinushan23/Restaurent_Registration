import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class RegistrationForm extends JFrame {
    private JTextField usernameField, emailField, phoneField, dobField;
    private JPasswordField passwordField;
    private JButton registerButton;

    public RegistrationForm() {
        setTitle("User Registration");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField(20);
        JLabel dobLabel = new JLabel("DOB:");
        dobField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        registerButton = new JButton("Register");

        int y = 0;
        gbc.gridx = 0; gbc.gridy = y; panel.add(usernameLabel, gbc);
        gbc.gridx = 1; gbc.gridy = y++; panel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = y; panel.add(emailLabel, gbc);
        gbc.gridx = 1; gbc.gridy = y++; panel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = y; panel.add(phoneLabel, gbc);
        gbc.gridx = 1; gbc.gridy = y++; panel.add(phoneField, gbc);

        gbc.gridx = 0; gbc.gridy = y; panel.add(dobLabel, gbc);
        gbc.gridx = 1; gbc.gridy = y++; panel.add(dobField, gbc);

        gbc.gridx = 0; gbc.gridy = y; panel.add(passwordLabel, gbc);
        gbc.gridx = 1; gbc.gridy = y++; panel.add(passwordField, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0; gbc.gridy = y++;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(registerButton, gbc);

        add(panel);
        setVisible(true);

        registerButton.addActionListener(e -> registerUser());
    }


    private void registerUser() {
        String username = usernameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String dob = dobField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || dob.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        if (!email.matches("^\\S+@\\S+\\.\\S+$")) {
            JOptionPane.showMessageDialog(this, "Invalid email format");
            return;
        }

        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "Phone must be 10 digits");
            return;
        }

        User user = new User(username, email, phone, dob, password);
        Database.saveUser(user);
    }
}
