package src.authentication.forms;

import javax.swing.*;
import javax.swing.border.Border;

import src.authentication.exceptions.InvalidRoleException;
import src.authentication.exceptions.InvalidSignUpException;
import src.authentication.exceptions.InvalidEmailException;
import src.authentication.exceptions.LowerCaseCharacterMissing;
import src.authentication.exceptions.Minimum8CharactersRequired;
import src.authentication.exceptions.NumberCharacterMissing;
import src.authentication.exceptions.PasswordException;
import src.authentication.exceptions.SpecialCharacterMissing;
import src.authentication.exceptions.UpperCaseCharacterMissing;
import src.main.PanelsManager;
import src.main.library.Library;
import src.main.library.Role;
import src.main.library.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class SignUp extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField roleTextField;
    private JTextField emailField;
    private JPasswordField passwordField;
    
    private JLabel libraryCardIDLabel;
    private JButton signupButton;
    public PanelsManager manager;

    private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    public SignUp(PanelsManager manager) {
        this.manager = manager;

        setLayout(new BorderLayout());

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(600, 600);
        setLayout(new GridLayout(19, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // App Label
        JLabel mainTitle = new JLabel("LMS - Sign Up");
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

        // Last Name
        JLabel roleLabel = new JLabel("Author/Librarian/Member: ");
        roleLabel.setForeground(Color.white);
        roleLabel.setFont(mainFont);
        roleTextField = new JTextField();
        roleTextField.setBorder(fieldBorder);

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

        passwordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                passwordField.setEchoChar((char) 0);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    throw new RuntimeException("time error oopsy");
                }
                passwordField.setEchoChar('*');
            }
        });

        // Error Message
        JLabel errorMessage = new JLabel();
        errorMessage.setHorizontalAlignment(JLabel.CENTER);
        errorMessage.setFont(new Font(fontFamily, Font.BOLD, 14));
        errorMessage.setForeground(Color.red);

        // SignUp Button
        signupButton = new JButton("Sign Up");
        signupButton.setFont(mainFont);
        signupButton.setBorder(fieldBorder);
        signupButton.setBackground(Color.WHITE);
        signupButton.setOpaque(true);

        // libraryCardID Label
        libraryCardIDLabel = new JLabel("");
        libraryCardIDLabel.setHorizontalAlignment(JLabel.CENTER);
        libraryCardIDLabel.setFont(new Font(fontFamily, Font.BOLD, 20));

                signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    String role = roleTextField.getText();
                    String email = emailField.getText();
                    String password = passwordField.getText();
                    String libraryCardID = generatelibraryCardID(firstName, lastName, email, password);
                if(!isEmpty(firstName) || !isEmpty(lastName) || !isEmpty(email)  || !isEmpty(password)){
                    if(libraryCardID != null){
                        String trueRole = role.trim().toLowerCase();
                        try{
                            if(!trueRole.equals("author") && !trueRole.equals("member") && !trueRole.equals("librarian")){
                                throw new InvalidRoleException();
                            }

                            if(!email.contains("@") || !email.contains(".")){
                                throw new InvalidEmailException("The chosen email is not valid, please try again with a valid email.");
                            }
                            for(User u : Library.getUsers()){
                                if(u.getEmail().equals(email)){
                                    throw new InvalidEmailException("The chosen email is already in use, please try again with a new email.");
                                }
                            }
                        }catch(InvalidSignUpException invRoleExc){
                            JOptionPane.showMessageDialog(SignUp.this, invRoleExc.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
                        }

                        errorMessage.setText("");
                        checkPasswordRequirements(password);
                        libraryCardIDLabel.setText(libraryCardID);
                        clearFields();

                        Role userRole = Role.MEMBER;
                        if (role.equalsIgnoreCase("librarian")){
                            userRole = Role.LIBRARIAN;
                        } else if(role.equalsIgnoreCase("author")){
                            userRole = Role.AUTHOR;
                        }
                        User newUser = new User(firstName, lastName, userRole, libraryCardID, email, password);
                        Library.addUser(newUser);
                    }
                }else{
                    libraryCardIDLabel.setText("");
                    errorMessage.setText("Invalid Input. Textfields must not be empty.");
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
                clearFields();
            }
        });

        add(mainTitle);
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(roleLabel);
        add(roleTextField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel());
        add(errorMessage);
        add(new JLabel());
        add(signupButton);
        add(new JLabel());
        add(switchButton);
        add(new JLabel());
        add(libraryCardIDLabel);
        
    }

        private String generatelibraryCardID(String firstName, String lastName, String email, String password) {
        if (firstName.length() > 0 || lastName.length() > 0 || email.length() > 0 || password.length() > 0) {
            char firstChar = firstName.charAt(0);
            char lastChar = lastName.charAt(0);
            int randomDigits = new Random().nextInt(9000) + 1000; // Generate a 4-digit random number

            return String.format("%C%C-%04d", firstChar, lastChar, randomDigits);
        }else{
            // Error Signing Up
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
