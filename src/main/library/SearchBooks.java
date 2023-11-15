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

    public static ArrayList<JLabel> labels = new ArrayList<>();

    public static JLabel searchBook(String searchedText) {
    // Trim the input string
    String trimmedISBN = searchedText.trim();

    JLabel bookInfo = new JLabel();
    bookInfo.setHorizontalAlignment(JLabel.CENTER); 
    bookInfo.setFont(new Font("Avenir", Font.BOLD, 14));
    bookInfo.setForeground(Color.white);


    // Check if the trimmed string is a number
    if (trimmedISBN.matches("\\d+")) {
        // It's a number, proceed with searching
        Book searchedBook = Library.searchByISBN(trimmedISBN);

        // Check if the book is found
        if (searchedBook != null) {
            String bookString = searchedBook.getTitle() + ", " + searchedBook.getAuthor() + ", " + searchedBook.getISBN();
            bookInfo.setText(bookString);
        } else {
             bookInfo.setText("Book not found for ISBN: " + trimmedISBN);
        }
    } else {
        ArrayList<Book> searchedBooks = Library.searchByTitle(searchedText);

       if (!searchedBooks.isEmpty()) {
            // Iterate through the first 5 books

            if(searchedBooks.size() > 5){
                int count = 0;
                for (Book searchedBook : searchedBooks) {
                    if (count < 5) {
                        String bookString = searchedBook.getTitle() + ", " + searchedBook.getAuthor() + ", " + searchedBook.getISBN();
                        labels.add(new JLabel(bookString));
                        count++;
                    } else {
                        break; // Stop after iterating through the first 5 books
                    }
                }
            }

            bookInfo.setText("Book not found for ISBN: " + trimmedISBN);

        } else {
            // No books found for the entered ISBN
             bookInfo.setText("No books found similar to that title");
        }
    }
        return bookInfo;
    }

    public PanelsManager manager;
    public SearchBooks(PanelsManager manager){{
        this.manager = manager;

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
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
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(Color.white);
        searchButton.setForeground(Color.black);


        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchedText = searchField.getText();
                System.out.println("Searching....");
                JLabel bookInfoLabel = searchBook(searchedText);

                // Trim the input string
                String trimmedISBN = searchedText.trim();

                // Check if the trimmed string is a number
                if (trimmedISBN.matches("\\d+")) {
                      add(bookInfoLabel);
                }else{
                    for (JLabel label : labels){
                            JLabel bookInfo = new JLabel(label.getText());
                            bookInfo.setHorizontalAlignment(JLabel.CENTER); 
                            bookInfo.setFont(new Font("Avenir", Font.BOLD, 14));
                            bookInfo.setForeground(Color.white);
                            add(bookInfo);
                    }
                     labels.clear();
                }

                validate();
                 repaint();
            }
        });

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(mainFont);
                backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(backButton);
                manager.showHomePanel();
                add(backButton);
            }
        });

        add(mainTitle);
        add(searchField);
        add(searchButton);
        add(backButton);
    }
}
}