package src.authentication.forms;
import javax.swing.*;
import javax.swing.border.Border;

import src.main.PanelsManager;
import src.main.library.Library;
import src.main.library.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SignIn extends JPanel {
    private JTextField libraryCardIDField;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JLabel messageLabel;
    public PanelsManager manager;
    public String currentLibraryCardID;

    public static boolean isEmailInList(ArrayList<User> userList, String enteredLibraryCardID, char[] enteredPassword) {
        for (User user : userList) {
            // Convert char array to String for comparison
            String passwordString = new String(enteredPassword);

            if (user.getLibraryCardID().equals(enteredLibraryCardID) && user.getPassword().equals(passwordString)) {
                return true; // Match found
            }
        }
        return false; // No match found
    }


    public SignIn(PanelsManager manager) {
        this.manager = manager;

        setLayout(new BorderLayout());
        Library.addTestUser();

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
        JLabel libraryCardIDlabel = new JLabel("Library Card ID:");
        libraryCardIDlabel.setFont(mainFont);
        libraryCardIDlabel.setForeground(Color.white);
        libraryCardIDField = new JTextField();
        libraryCardIDField.setBorder(fieldBorder);

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
        messageLabel.setForeground(new Color(230,48,79));
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
                String enteredLibraryCardID = libraryCardIDField.getText();
                char[] enteredPassword = passwordField.getPassword();

                ArrayList<User> users = Library.getUsers();
                if(isEmailInList(users, enteredLibraryCardID, enteredPassword) == true){
                     libraryCardIDField.setText("");
                     passwordField.setText("");
                     messageLabel.setText("");
                     manager.showHomePanel();
                     manager.makeProfilePanel(enteredLibraryCardID);
                     manager.makeSearchPanel();
                     manager.makeBorrowPage();
                     manager.makeReturnPage();
                     currentLibraryCardID = enteredLibraryCardID;
        
                }else{
                     messageLabel.setText("LibraryCardID or password may be incorrect. LibraryCardID is case sensitive.");
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
        add(libraryCardIDlabel);
        add(libraryCardIDField);
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
