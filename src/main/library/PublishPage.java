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
        JLabel addRemoveLabel = new JLabel("Enter the title, author name, ISBN, and genre, separated by commas.");
        addRemoveLabel.setFont(new Font(fontFamily, Font.BOLD, 14));
        addRemoveLabel.setForeground(Color.white);

        // Search Field
        JTextField ISBNSearchField = new JTextField();
        ISBNSearchField.setBorder(fieldBorder);

        // Add Button
        JButton addButton = new JButton("Publish a book");
        addButton.setBackground(Color.white);
        addButton.setForeground(Color.black);

        //Status message label
        JLabel bookInfoLabel = new JLabel();
        bookInfoLabel.setHorizontalAlignment(JLabel.CENTER);
        bookInfoLabel.setFont(new Font("Avenir", Font.BOLD, 14));
        bookInfoLabel.setForeground(Color.white);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String getBook = ISBNSearchField.getText();
                    String[] bookData = getBook.split(",");
                    Genre genre = Genre.getGenre(bookData[3]);
                    // title author isbn genre
                    if (bookData.length == 4) {
                        Book book = new Book(bookData[0], bookData[1], bookData[2], genre, Status.CHECKED_IN);
                        bookInfoLabel.setText("Book published.");
                        addBook(book);
                    }
                } catch (Exception exc) {
                    System.out.println("invalid book");
                    bookInfoLabel.setText("Invalid book.\nBook format is: Title, Author, ISBN, Genre");
                }

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
        add(addRemoveLabel);
        add(ISBNSearchField);
        add(addButton);
        add(new JLabel());
        add(backButton);
        add(bookInfoLabel);
    }

    public static void addBook(Book b){
        Library.addBook(b);
    }

    public static void removeBook(Book b) {
        Library.removeBook(b);
    }
}
