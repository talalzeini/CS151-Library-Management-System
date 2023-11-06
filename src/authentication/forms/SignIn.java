package src.authentication.forms;
import javax.swing.*;
import javax.swing.border.Border;

import src.main.PanelsManager;
import src.main.UserManager;
import src.main.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SignIn extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;
    public PanelsManager manager;

    public static boolean isEmailInList(ArrayList<User> userList, String enteredUsername, String enteredPassword) {
        for (User user : userList) {
            if (user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword)) {
                return true; // Match found
            }
        }
        return false; // No match found
    }

    public SignIn(PanelsManager manager) {
        this.manager = manager;

        setLayout(new BorderLayout());
        UserManager.addTestUser();

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(500, 500);
        setLayout(new GridLayout(10, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // App Label
        JLabel mainTitle = new JLabel("LMS - Sign In");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(fontFamily, Font.BOLD, 20));

             // Email
        JLabel usernamelabel = new JLabel("Username:");
        usernamelabel.setFont(mainFont);
        usernameField = new JTextField();
        usernameField.setBorder(fieldBorder);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(mainFont);
        passwordField = new JPasswordField();
        passwordField.setBorder(fieldBorder);

        // Message Label
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.red);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setFont(mainFont);
        loginButton.setBorder(fieldBorder);
        loginButton.setBackground(Color.WHITE);
        loginButton.setOpaque(true);

                loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = usernameField.getText();
                String enteredPassword = passwordField.getText();

                ArrayList<User> users = UserManager.getUsers();
                System.out.println(users);
                if(isEmailInList(users, enteredUsername, enteredPassword) == true){
                     usernameField.setText("");
                     passwordField.setText("");
                     messageLabel.setText("");
                     manager.showHomePanel();
                     manager.makeProfilePanel(enteredUsername);
                }else{
                     messageLabel.setText("Username or password may be incorrect. Username is case sensitive.");
                }
            
            }
        });


        JButton switchButton = new JButton("Don't have an account? Sign Up");
        switchButton.setFont(mainFont);
        switchButton.setBorder(fieldBorder);
        switchButton.setBackground(Color.WHITE);
        switchButton.setOpaque(true);

        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.showSignUpPanel();
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
        add(usernamelabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(messageLabel);
        add(loginButton);
        add(new JLabel());
        add(switchButton);
    }
}
