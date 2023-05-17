package finalProject.views;

import finalProject.models.Store;
import finalProject.controllers.LoginController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Alex Reburn
 */
public class LoginViewUI extends JFrame {
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private LoginController loginController;

    public LoginViewUI(Store store) {
        // Initialize the UI components
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameTextField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        // Create a new LoginController instance to handle login attempts
        loginController = new LoginController(this, store);

        // Set up the UI layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        // Set up the login button action listener
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(passwordField.getPassword());

                // Call the login method of the LoginController to handle the login attempt
                loginController.login(username, password);
            }
        });

        // Set up the window properties
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}