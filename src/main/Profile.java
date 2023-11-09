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
import java.awt.*;

public class Profile extends JPanel {

    public static User showProfileData(String username) {
        ArrayList<User> users = UserManager.getUsers();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
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

    public void updatePassword(User signedInUser, String newPassword){
        signedInUser.setPassword(newPassword);
        System.out.println("updatePassword function still needs exceptions");
    }

    public PanelsManager manager;
    public Profile(PanelsManager manager, String username){
        this.manager = manager;

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(600, 600);
        setLayout(new GridLayout(13, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        User signedInUser = showProfileData(username);
        String firstName = signedInUser.getFirstName();
        String lastName = signedInUser.getLastName();
        String usernameString = signedInUser.getUsername();
        String email = signedInUser.getEmail();

        // App Label
        JLabel mainTitle = new JLabel("StudyBuddy - Welcome " + firstName);
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

        // Username Label
        JLabel usernameLabel = new JLabel("Username: " + usernameString);
        usernameLabel.setHorizontalAlignment(JLabel.LEFT);
        usernameLabel.setFont(mainFont);
        usernameLabel.setForeground(Color.white);

        // Email Label
        JLabel emailLabel = new JLabel("Email: " + email);
        emailLabel.setHorizontalAlignment(JLabel.LEFT);
        emailLabel.setFont(mainFont);
        emailLabel.setForeground(Color.white);

        // Password Label
        // JLabel passwordLabel = new JLabel("Password: " + password);
        // passwordLabel.setHorizontalAlignment(JLabel.LEFT);
        // passwordLabel.setFont(mainFont);
        // passwordLabel.setForeground(Color.white);


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

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(newPasswordLabel.isVisible()){
                    updatePassword(signedInUser, newPasswordField.getText());
                    System.out.println("Changed Password Successfully");
                }else{
                    showChangingPasswordFields(newPasswordLabel, newPasswordField);
                    System.out.println("Changed Password Show");
                }
                
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
        add(usernameLabel);
        add(emailLabel);
        // add(passwordLabel);
        add(changePasswordButton);
        add(new JLabel());
        add(newPasswordLabel);
        add(newPasswordField);
        add(new JLabel());
        add(LogOutButton);
    }
}
