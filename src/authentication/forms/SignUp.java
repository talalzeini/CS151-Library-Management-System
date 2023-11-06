package src.authentication.forms;

import javax.swing.*;
import javax.swing.border.Border;

import src.authentication.exceptions.LowerCaseCharacterMissing;
import src.authentication.exceptions.Minimum8CharactersRequired;
import src.authentication.exceptions.NumberCharacterMissing;
import src.authentication.exceptions.PasswordException;
import src.authentication.exceptions.SpecialCharacterMissing;
import src.authentication.exceptions.UpperCaseCharacterMissing;
import src.main.PanelsManager;
import src.main.User;
import src.main.UserManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUp extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JButton signupButton;
    public PanelsManager manager;
    
    public SignUp(PanelsManager manager) {
        this.manager = manager;

        setLayout(new BorderLayout());

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(600, 600);
        setLayout(new GridLayout(15, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // App Label
        JLabel mainTitle = new JLabel("StudyBuddy - Sign Up");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        mainTitle.setForeground(Color.white);

        // First Name 
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setForeground(Color.white);
        firstNameLabel.setFont(mainFont);
        firstNameField = new JTextField();
        firstNameField.setBorder(fieldBorder);
      
        // Last Name
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setForeground(Color.white);
        lastNameLabel.setFont(mainFont);
        lastNameField = new JTextField();
        lastNameField.setBorder(fieldBorder);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(mainFont);
        emailField = new JTextField();
        emailField.setBorder(fieldBorder);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(mainFont);
        passwordField = new JPasswordField();
        passwordField.setBorder(fieldBorder);

        // SignUp Button
        signupButton = new JButton("Sign Up");
        signupButton.setFont(mainFont);
        signupButton.setBorder(fieldBorder);
        signupButton.setBackground(Color.WHITE);
        signupButton.setOpaque(true);

        // Username Label
        usernameLabel = new JLabel("");
        usernameLabel.setHorizontalAlignment(JLabel.CENTER);
        usernameLabel.setFont(new Font(fontFamily, Font.BOLD, 20));

                signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String password = passwordField.getText();
                String username = generateUsername(firstName, lastName, email, password);
                
                if(username != null){
                    checkPasswordRequirements(password);
                    clearFields();
                    User newUser = new User(firstName, lastName, username, email, password);
                    UserManager.addUser(newUser);
                    // printUserList();
                }
            }catch (PasswordException pe) {
            // Display the appropriate error message on the screen
            JOptionPane.showMessageDialog(SignUp.this, pe.getMessage(), "Password Requirement Error", JOptionPane.ERROR_MESSAGE);
        }
            }
        });

        JButton switchButton = new JButton("Already have an account? Sign In");
        switchButton.setFont(mainFont);
        switchButton.setBorder(fieldBorder);
        switchButton.setBackground(Color.WHITE);
        switchButton.setOpaque(true);

        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.showSignInPanel();
            }
        });

        JButton backHomeButton = new JButton("Home");
        backHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.showHomePanel();
            }
        });

        add(mainTitle);
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());
        add(signupButton);
        add(new JLabel());
        add(switchButton);
        add(new JLabel());
        add(usernameLabel);
        
    }

        private String generateUsername(String firstName, String lastName, String email, String password) {
        if (firstName.length() > 0 && lastName.length() > 0 && email.length() > 0 && password.length() > 0) {
            char firstChar = firstName.charAt(0);
            char lastChar = lastName.charAt(0);
            int randomDigits = new Random().nextInt(9000) + 1000; // Generate a 4-digit random number

            String username = String.format("%C%C-%04d", firstChar, lastChar, randomDigits);
            usernameLabel.setText("Username: " + username);
            return username;
        }else{
            System.out.println("Erorr");
            return null;
        }
    }

        private void checkPasswordRequirements(String password) throws PasswordException {
    if (password.length() < 8) {
        throw new Minimum8CharactersRequired();
    }

    if (!password.matches(".*[A-Z].*")) {
        throw new UpperCaseCharacterMissing();
    }

    if (!password.matches(".*[a-z].*")) {
        throw new LowerCaseCharacterMissing();
    }

    if (!password.matches(".*[!@#$%^&*()].*")) {
        throw new SpecialCharacterMissing();
    }

    if (!password.matches(".*\\d.*")) {
        throw new NumberCharacterMissing();
    }
}


    private void clearFields(){
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        passwordField.setText("");
    }
}
