package src.main;
import javax.swing.*;
import src.authentication.forms.*;
import src.main.library.AddRemovePage;
import src.main.library.SearchBooks;
import src.main.library.BorrowPage;
import src.main.library.ReturnPage;
import java.awt.*;

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

        public void makeBorrowPage() {
        BorrowPage borrowPagePanel = new BorrowPage(this);
        cardPanel.add(borrowPagePanel, "BorrowPage");  
        borrowPagePanel.setBackground(defaultBackgroundColor);
    }

    public void showBorrowPage(){
        cardLayout.show(cardPanel, "BorrowPage");      
    }

    public void makeReturnPage() {
        ReturnPage ReturnPagePanel = new ReturnPage(this);
        cardPanel.add(ReturnPagePanel, "ReturnPage");  
        ReturnPagePanel.setBackground(defaultBackgroundColor);
    }

    public void showReturnPage(){
        cardLayout.show(cardPanel, "ReturnPage");      
    }

    public void makeAddRemovePage(){
        AddRemovePage addRemovePanel = new AddRemovePage(this);
        cardPanel.add(addRemovePanel, "addRemovePage");
        addRemovePanel.setBackground(defaultBackgroundColor);
    }

    public void showAddRemovePage(){
        cardLayout.show(cardPanel, "addRemovePage");
    }

    public void makePublishPage(){
        AddRemovePage publishPanel = new AddRemovePage(this);
        cardPanel.add(publishPanel, "publishPage");
        publishPanel.setBackground(defaultBackgroundColor);
    }

    public void showPublishPage(){
        cardLayout.show(cardPanel, "publishPage");
    }
    
}