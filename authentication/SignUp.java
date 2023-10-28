package authentication;

import javax.swing.*;

import main.PanelsManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JPanel {
    private PanelsManager manager;
    
    public SignUp(PanelsManager manager) {
        this.manager = manager;

        setLayout(new BorderLayout());
        add(new JLabel("Sign Up"), BorderLayout.CENTER);

        JButton switchButton = new JButton("Already have an account? Sign In");
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.showSignInPanel();
            }
        });

        JButton backHomeButton = new JButton("Home");
        backHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.showHomePanel();
            }
        });

        add(switchButton, BorderLayout.SOUTH);
        add(backHomeButton, BorderLayout.NORTH);
        add(new JLabel("Sign Up"));
    }
}
