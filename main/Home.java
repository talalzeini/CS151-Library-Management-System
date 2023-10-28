package main;
import javax.swing.*;

import java.awt.*;

public class Home extends JPanel {
    private PanelsManager manager;

    public Home(PanelsManager manager) {
        this.manager = manager;
        
        setLayout(new BorderLayout());
        add(new JLabel("Home Page"), BorderLayout.CENTER);

    }
}