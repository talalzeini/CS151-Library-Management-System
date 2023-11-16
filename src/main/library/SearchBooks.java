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

    private JLabel bookInfoLabel;
    private static int page;

    public static ArrayList<String> bookList = new ArrayList<>();

    public static void searchBook(String searchedText) {
    // Trim the input string
    String trimmedISBN = searchedText.trim();


    // Check if the trimmed string is a number
    if (trimmedISBN.matches("\\d+")) {
        // It's a number, proceed with searching
        Book searchedBook = Library.searchByISBN(trimmedISBN);

        // Check if the book is found
        if (searchedBook != null) {
            String bookString = searchedBook.getTitle() + ", " + searchedBook.getAuthor() + ", " + searchedBook.getISBN();
            bookList.add(bookString);
        }
    } else {
        ArrayList<Book> searchedBooks = Library.searchByTitle(searchedText);

        for (Book b : searchedBooks) {
            bookList.add(b.getTitle() + ", " + b.getAuthor() + ", " + b.getISBN());
        }
    }
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
        JLabel mainTitle = new JLabel("Search for a book by title or ISBN");
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

        //NONFUNCTIONAL:
//        // Next page button
//        JButton nextPageButton = new JButton("Next Page");
//        nextPageButton.setBackground(Color.white);
//        nextPageButton.setForeground(Color.black);
//
//        nextPageButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                page++;
//            }
//        });
//
//        // Previous page button
//        JButton prevPageButton = new JButton("Previous Page");
//        prevPageButton.setBackground(Color.white);
//        prevPageButton.setForeground(Color.black);
//
//        prevPageButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                page--;
//            }
//        });

        ArrayList<JLabel> labels = new ArrayList<JLabel>();
        labels.add(new JLabel());
        labels.add(new JLabel());
        labels.add(new JLabel());
        labels.add(new JLabel());
        labels.add(new JLabel());

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchedText = searchField.getText();
                System.out.println("Searching....");
                searchBook(searchedText);

                // Trim the input string
                String trimmedISBN = searchedText.trim();

                // Check if the trimmed string is a number
                if (trimmedISBN.matches("\\d+")) {
                      labels.get(0).setText(bookList.get(0));
                    for (int i = 1; i < 5; i++){
                        labels.get(i).setText("");
                    }
                } else if (!trimmedISBN.isEmpty()) {
                    for (int i = page*5; i < page*5+5; i++){
                        if (page*5+i < labels.size()){
                            labels.get(page*5+i).setText(bookList.get(page*5+i));
                        }
                    }
                } else {
                    for (int i = 0; i < 5; i++){
                        labels.get(i).setText("");
                    }
                }
            }
        });

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(mainFont);
                backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.showHomePanel();
            }
        });

        add(mainTitle);
        add(searchField);
        add(searchButton);
        add(backButton);
        for (JLabel j : labels) {
            j.setFont(new Font(fontFamily, Font.PLAIN, 14));
            j.setForeground(Color.white);
            add(j);
        }
    }
}
}