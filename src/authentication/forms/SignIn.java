package src.authentication.forms;
import javax.swing.*;
import javax.swing.border.Border;

import src.main.PanelsManager;
import src.main.UserManager;
import src.main.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SignIn extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton;
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

        setSize(600, 600);
        setLayout(new GridLayout(10, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // App Label
        JLabel mainTitle = new JLabel("LMS - Sign In");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        mainTitle.setForeground(Color.white);

             // Email
        JLabel usernamelabel = new JLabel("Username:");
        usernamelabel.setFont(mainFont);
        usernamelabel.setForeground(Color.white);
        usernameField = new JTextField();
        usernameField.setBorder(fieldBorder);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(mainFont);
        passwordLabel.setForeground(Color.white);
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

        // Message Label
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.red);
        messageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Sign In Button
        signInButton = new JButton("Sign In");
        signInButton.setFont(mainFont);
        signInButton.setBorder(fieldBorder);
        signInButton.setBackground(Color.WHITE);
        signInButton.setOpaque(true);

                signInButton.addActionListener(new ActionListener() {
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
                clearPasswordField();
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
        add(signInButton);
        add(new JLabel());
        add(switchButton);
    }

    private void clearPasswordField(){
        passwordField.setText("");
    }
}
