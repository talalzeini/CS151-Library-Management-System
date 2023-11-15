package src.main;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.border.Border;

import src.authentication.exceptions.*;
import src.main.library.Library;
import src.main.library.User;

import java.awt.*;

public class Profile extends JPanel {

    private String passwordErrorMessage;

    public static User showProfileData(String username) {
        ArrayList<User> users = Library.getUsers();
        for (User user : users) {
            if (user.getLibraryCardID().equals(username)) {
                return user; // Match found
            }
        }
        return null;
    }

    public void showChangingPasswordFields(JLabel newPasswordLabel, JTextField newPasswordField){
        newPasswordLabel.setVisible(true);
        newPasswordField.setVisible(true);
    }

    public void hideChangingPasswordFields(JLabel newPasswordLabel, JTextField newPasswordField){
        newPasswordLabel.setVisible(false);
        newPasswordField.setVisible(false);
    }

    public void updatePassword(User signedInUser, char[] newPassword) {
        // Convert char array to String
        String newPasswordString = new String(newPassword);
        
        signedInUser.setPassword(newPasswordString);
        // Add exception handling if needed
    }

    private void checkPasswordRequirements(String password) throws PasswordException {
        if (password.length() < 8) {throw new Minimum8CharactersRequired();}

        if (!password.matches(".*[A-Z].*")) {throw new UpperCaseCharacterMissing();}

        if (!password.matches(".*[a-z].*")) {throw new LowerCaseCharacterMissing();}

        if (!password.matches(".*[!@#$%^&*()].*")) {throw new SpecialCharacterMissing();}

        if (!password.matches(".*\\d.*")) {throw new NumberCharacterMissing();}
    }


    public PanelsManager manager;
    public Profile(PanelsManager manager, String libraryCardID){
        this.manager = manager;

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(600, 600);
        setLayout(new GridLayout(15, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        User signedInUser = showProfileData(libraryCardID);
        String firstName = signedInUser.getFirstName();
        String lastName = signedInUser.getLastName();
        String libraryCardIDString = signedInUser.getLibraryCardID();
        String roleString = signedInUser.getRole();
        String email = signedInUser.getEmail();

        // App Label
        JLabel mainTitle = new JLabel("Welcome Back, " + firstName);
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        mainTitle.setForeground(Color.white);

        // First Name Label
        JLabel firstNameLabel = new JLabel("First Name: " + firstName);
        firstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        firstNameLabel.setFont(mainFont);
        firstNameLabel.setForeground(Color.white);

        // Last Name Label
        JLabel lastNameLabel = new JLabel("Last Name: " + lastName);
        lastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        lastNameLabel.setFont(mainFont);
        lastNameLabel.setForeground(Color.white);

        // LibraryCardID Label
        JLabel libraryCardIDLabel = new JLabel("Library Card ID: " + libraryCardIDString);
        libraryCardIDLabel.setHorizontalAlignment(JLabel.LEFT);
        libraryCardIDLabel.setFont(mainFont);
        libraryCardIDLabel.setForeground(Color.white);

        // Role Label
        JLabel roleLabel = new JLabel("Role: " + roleString);
        roleLabel.setHorizontalAlignment(JLabel.LEFT);
        roleLabel.setFont(mainFont);
        roleLabel.setForeground(Color.white);

        // Email Label
        JLabel emailLabel = new JLabel("Email: " + email);
        emailLabel.setHorizontalAlignment(JLabel.LEFT);
        emailLabel.setFont(mainFont);
        emailLabel.setForeground(Color.white);

        // New Password Label
        JLabel newPasswordLabel = new JLabel("New Password: ");
        newPasswordLabel.setHorizontalAlignment(JLabel.LEFT);
        newPasswordLabel.setFont(mainFont);
        newPasswordLabel.setForeground(Color.white);

        // New Password Field
        JPasswordField newPasswordField = new JPasswordField();
        newPasswordField.setBorder(fieldBorder);
        setVisible(false);

        newPasswordField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                newPasswordField.setEchoChar((char) 0);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                try {
                    Thread.sleep(30);
                } catch (InterruptedException ex) {
                    throw new RuntimeException("time error oopsy");
                }
                newPasswordField.setEchoChar('*');
            }
        });

        // Change Password Button
        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setFont(mainFont);
        changePasswordButton.setBorder(fieldBorder);
        changePasswordButton.setBackground(Color.WHITE);
        changePasswordButton.setOpaque(true);

        hideChangingPasswordFields(newPasswordLabel, newPasswordField);

        JLabel errorLabel = new JLabel();
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
        errorLabel.setFont(new Font(fontFamily, Font.PLAIN, 14));
        Color successColor = Color.GREEN;
        Color failColor = new Color(230,48,79);

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(newPasswordLabel.isVisible()){
                    if (newPasswordField.getPassword() != null) {
                        // check password validity
                        try {
                            checkPasswordRequirements(new String(newPasswordField.getPassword()));
                            updatePassword(signedInUser, newPasswordField.getPassword());
                            errorLabel.setForeground(successColor);
                            errorLabel.setText("Password changed successfully.");
                        } catch (PasswordException ex) {
                            errorLabel.setForeground(failColor);
                            errorLabel.setText("Invalid password. " + ex.getMessage());
                        }
                    } else {
                        hideChangingPasswordFields(newPasswordLabel, newPasswordField);
                    }
                }else{
                    showChangingPasswordFields(newPasswordLabel, newPasswordField);
                }
            }
        });

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(mainFont);
                backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(backButton);
                manager.showHomePanel();
                add(backButton);
            }
        });
        

        // LogOut Button
        JButton LogOutButton = new JButton("Log Out");
        LogOutButton.setFont(mainFont);
        LogOutButton.setBorder(fieldBorder);
        LogOutButton.setBackground(Color.WHITE);
        LogOutButton.setOpaque(true);

        LogOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.showSignInPanel();
            }
        });

        add(mainTitle);
        add(firstNameLabel);
        add(lastNameLabel);
        add(libraryCardIDLabel);
        add(roleLabel);
        add(emailLabel);
        add(changePasswordButton);
        add(errorLabel);
        add(newPasswordLabel);
        add(newPasswordField);
        add(new JLabel());
        add(LogOutButton);
        add(backButton);
    }
}