package src.main;
import javax.swing.*;
import src.authentication.forms.*;
import src.main.library.Library;
import src.main.library.SearchBooks;
import src.main.library.User;

import java.awt.*;
import java.util.ArrayList;

public class PanelsManager extends JPanel {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private Color defaultBackgroundColor;

    public PanelsManager() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        SignIn signInPanel = new SignIn(this);
        SignUp signUpPanel = new SignUp(this);
        Home homePanel = new Home(this);

        cardPanel.add(signInPanel, "SignIn");
        cardPanel.add(signUpPanel, "SignUp");
        cardPanel.add(homePanel, "Home");

        defaultBackgroundColor = new Color(58,162,166);
        signInPanel.setBackground(defaultBackgroundColor);
        signUpPanel.setBackground(defaultBackgroundColor);
        homePanel.setBackground(defaultBackgroundColor);

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
        profilePanel.setBackground(defaultBackgroundColor);
    }

    public void showProfilePanel(){
        cardLayout.show(cardPanel, "Profile");      
    }

    public void makeSearchPanel() {
        SearchBooks searchPanel = new SearchBooks(this);
        cardPanel.add(searchPanel, "Search");  
        searchPanel.setBackground(defaultBackgroundColor);
    }

    public void showSearchPanel(){
        cardLayout.show(cardPanel, "Search");      
    }

}
