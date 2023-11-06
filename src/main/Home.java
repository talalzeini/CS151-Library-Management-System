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
        
        setSize(600, 600);
        setLayout(new GridLayout(6, 3));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Home Title
        JLabel homeTitle = new JLabel("Welcome to LMS");
        homeTitle.setHorizontalAlignment(JLabel.CENTER);
        homeTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        homeTitle.setForeground(Color.white);

        JButton openProfileButton = new JButton("My Profile");
        openProfileButton.setFont(mainFont);
        openProfileButton.setBackground(Color.WHITE);
        openProfileButton.setOpaque(true);

        // Narrative Genre Button 
        JButton narrativeButton = new JButton("Narrative");
        narrativeButton.setFont(mainFont);

        // Novel Genre Button 
        JButton novelButton = new JButton("Novel");
        novelButton.setFont(mainFont);

        // Novel Genre Button 
        JButton scienceFictionButton = new JButton("Science Fiction");
        scienceFictionButton.setFont(mainFont);

        // Novel Genre Button 
        JButton thrillerButton = new JButton("Thriller");
        thrillerButton.setFont(mainFont);

        openProfileButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            manager.showProfilePanel();
        }
        });

        add(new JLabel());
        add(homeTitle);
        add(new JLabel());

        add(openProfileButton);
        add(new JLabel());
        add(new JLabel());

        add(narrativeButton);
        add(new JLabel());
        add(new JLabel());

        add(novelButton);
        add(new JLabel());
        add(new JLabel());

        add(scienceFictionButton);
        add(new JLabel());
        add(new JLabel());

        add(thrillerButton);
        add(new JLabel());
        add(new JLabel());
    }
}