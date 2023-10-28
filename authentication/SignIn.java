package authentication;

import javax.swing.*;

import main.PanelsManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignIn extends JPanel {
    private PanelsManager manager;
    
    public SignIn(PanelsManager manager) {
        this.manager = manager;

        setLayout(new BorderLayout());
        add(new JLabel("Sign In"), BorderLayout.CENTER);

        JButton switchButton = new JButton("Don't have an account? Sign Up");
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.showSignUpPanel();
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
        add(new JLabel("Sign In"));
    }
}
