package src.main;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

    public PanelsManager manager;
    public Profile(PanelsManager manager, String username){
        this.manager = manager;

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(600, 600);
        setLayout(new GridLayout(10, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));


        User signedInUser = showProfileData(username);
        String firstName = signedInUser.getFirstName();
        String lastName = signedInUser.getLastName();
        String usernameString = signedInUser.getUsername();
        String email = signedInUser.getEmail();
        String password = signedInUser.getPassword();

        // App Label
        JLabel mainTitle = new JLabel("StudyBuddy - Welcome " + firstName);
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        mainTitle.setForeground(Color.white);

        JLabel firstNameLabel = new JLabel("First Name: " + firstName);
        firstNameLabel.setHorizontalAlignment(JLabel.LEFT);
        firstNameLabel.setFont(mainFont);
        firstNameLabel.setForeground(Color.white);

        JLabel lastNameLabel = new JLabel("Last Name: " + lastName);
        lastNameLabel.setHorizontalAlignment(JLabel.LEFT);
        lastNameLabel.setFont(mainFont);
        lastNameLabel.setForeground(Color.white);

        JLabel usernameLabel = new JLabel("Username: " + usernameString);
        usernameLabel.setHorizontalAlignment(JLabel.LEFT);
        usernameLabel.setFont(mainFont);
        usernameLabel.setForeground(Color.white);

        JLabel emailLabel = new JLabel("Email: " + email);
        emailLabel.setHorizontalAlignment(JLabel.LEFT);
        emailLabel.setFont(mainFont);
        emailLabel.setForeground(Color.white);

        JLabel passwordLabel = new JLabel("Password: " + password);
        passwordLabel.setHorizontalAlignment(JLabel.LEFT);
        passwordLabel.setFont(mainFont);
        passwordLabel.setForeground(Color.white);

        JButton switchButton = new JButton("Log Out");
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

        add(mainTitle);
        add(firstNameLabel);
        add(lastNameLabel);
        add(usernameLabel);
        add(emailLabel);
        add(passwordLabel);
        add(switchButton);
    }
}
