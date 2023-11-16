package src.main.library;

import src.main.PanelsManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**Represents the UI panel from which Authors can publish books to the library. */
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


        //Button publishes a book to the library
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String getBook = ISBNSearchField.getText();
                    String[] bookData = getBook.split(",");
                    Genre genre = Genre.getGenre(bookData[3]);
                    // Making sure ISBN is unique
                    for(Book b : Library.getInventory()){
                        if(b.getISBN().equals(bookData[2])){
                            throw new Exception();
                        }
                    }
                    // title author isbn genre
                    if (bookData.length == 4) {
                        Book book = new Book(bookData[0], bookData[1], bookData[2], genre, Status.CHECKED_IN);
                        bookInfoLabel.setText("Book published.");
                        addBook(book);
                    }
                } catch (Exception exc) {
                    System.out.println("invalid book/ISBN");
                    bookInfoLabel.setText("Invalid book/Repeated ISBN.\nBook format is: Title, Author, ISBN, Genre");
                }

            }
        });

        //Back button to get to previous page
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

    //Calls library addbook
    public static void addBook(Book b){
        Library.addBook(b);
    }

    //Calls library removeBook
    public static void removeBook(Book b) {
        Library.removeBook(b);
    }
}
