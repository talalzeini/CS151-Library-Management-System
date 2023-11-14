package src.main.library;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTextField;
import javax.swing.border.Border;

import src.main.PanelsManager;


import java.awt.*;

public class SearchBooks extends JPanel {

    public static JLabel showBooksByISBN(String searchedISBN) {
        Book searchedBook = Library.searchByISBN(searchedISBN);
        System.out.println(searchedBook.getTitle());

        String bookString = searchedBook.getTitle() + ", " + searchedBook.getAuthor() + ", " + searchedBook.getISBN();

        JLabel bookInfo = new JLabel(bookString);
        bookInfo.setHorizontalAlignment(JLabel.CENTER); 
        bookInfo.setFont(new Font("Avenir", Font.BOLD, 14));
        bookInfo.setForeground(Color.white);
        return bookInfo;

    }

    public PanelsManager manager;
    public SearchBooks(PanelsManager manager){{
        this.manager = manager;

        String fontFamily = "Avenir";
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(600, 600);
        setLayout(new GridLayout(13, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // App Label
        JLabel mainTitle = new JLabel("Hi");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        mainTitle.setForeground(Color.white);

        // Search Field
        JTextField searchField = new JTextField();
        searchField.setBorder(fieldBorder);

        // Search Button
        JButton searchButton = new JButton("Hello");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(Color.black);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchedText = searchField.getText();
                System.out.println("Searching....");
                JLabel bookInfo = showBooksByISBN(searchedText);
                add(bookInfo);
            }
        });

        add(mainTitle);
        add(searchField);
        add(searchButton);
    }
}
}
