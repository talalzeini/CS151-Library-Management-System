package src.main;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Home extends JPanel {
    private PanelsManager manager;

    public Home(PanelsManager manager) {
        this.manager = manager;

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        
        setSize(500, 500);
        setLayout(new GridLayout(2, 1));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Home Title
        JLabel homeTitle = new JLabel("Welcome to LMS");
        homeTitle.setHorizontalAlignment(JLabel.CENTER);
        homeTitle.setFont(new Font(fontFamily, Font.BOLD, 20));

        JButton openProfileButton = new JButton("My Profile");
        openProfileButton.setFont(mainFont);
        openProfileButton.setBackground(Color.WHITE);
        openProfileButton.setOpaque(true);

        openProfileButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            manager.showProfilePanel();
        }
        });

        add(homeTitle);
        add(openProfileButton);

    }
}