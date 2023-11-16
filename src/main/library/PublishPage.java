package src.main.library;

import src.main.PanelsManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublishPage extends JPanel {

    public PanelsManager manager;
    public PublishPage(PanelsManager manager) {

        this.manager = manager;

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(600, 600);
        setLayout(new GridLayout(13, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // App Label
        JLabel mainTitle = new JLabel();
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        mainTitle.setForeground(Color.white);

        // Input Label
        JLabel returnLabel = new JLabel("Enter your book's ISBN here: ");
        returnLabel.setFont(new Font(fontFamily, Font.BOLD, 14));
        returnLabel.setForeground(Color.white);

        // Search Field
        JTextField ISBNSearchField = new JTextField();
        ISBNSearchField.setBorder(fieldBorder);

        // Publish
        JButton addButton = new JButton("Add a book");
        addButton.setBackground(Color.white);
        addButton.setForeground(Color.black);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Remove Button
        JButton removeButton = new JButton("Remove a book");
        removeButton.setBackground(Color.white);
        removeButton.setForeground(Color.black);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        //Status message label
        JLabel bookInfoLabel = new JLabel();
        //JLabel bookInfoLabel = new JLabel(statusMessage);
        bookInfoLabel.setHorizontalAlignment(JLabel.CENTER);
        bookInfoLabel.setFont(new Font("Avenir", Font.BOLD, 14));
        bookInfoLabel.setForeground(Color.white);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchedText = ISBNSearchField.getText();
                System.out.println("Returning....");
                //statusMessage = returnBookNow(searchedText);
                //bookInfoLabel.setText(statusMessage);
                validate();
                repaint();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setFont(mainFont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.showHomePanel();
                bookInfoLabel.setText("");
            }
        });

        add(mainTitle);
        add(ISBNSearchField);
        add(addButton);
        add(removeButton);
        add(backButton);
        add(bookInfoLabel);
    }
}
