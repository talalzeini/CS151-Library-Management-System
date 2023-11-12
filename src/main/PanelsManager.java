package src.main;
import javax.swing.*;
import src.authentication.forms.*;
import java.awt.*;

public class PanelsManager extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    public PanelsManager() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        SignIn signInPanel = new SignIn(this);
        SignUp signUpPanel = new SignUp(this);
        Home homePanel = new Home(this);

        cardPanel.add(signInPanel, "SignIn");
        cardPanel.add(signUpPanel, "SignUp");
        cardPanel.add(homePanel, "Home");

        signInPanel.setBackground(Color.blue);
        signUpPanel.setBackground(Color.blue);
        homePanel.setBackground(Color.blue);

        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
    }

    public void showSignInPanel() {
        cardLayout.show(cardPanel, "SignIn");
    }

    public void showSignUpPanel() {
        cardLayout.show(cardPanel, "SignUp");
    }

    public void showHomePanel() {
        cardLayout.show(cardPanel, "Home");
    }

    public void makeProfilePanel(String username) {
        Profile profilePanel = new Profile(this, username);
        cardPanel.add(profilePanel, "Profile");  
        profilePanel.setBackground(Color.blue);
    }

    public void showProfilePanel(){
        cardLayout.show(cardPanel, "Profile");      
    }

}
