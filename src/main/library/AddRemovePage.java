package src.main.library;

import src.main.PanelsManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**UI component that handles adding/removing books */
public class AddRemovePage extends JPanel {

    public PanelsManager manager;

    /**
     * Constructor to create a page which has the add/remove function to the library.
     * @param manager The PanelsManager object controlling the UI components of the page.
     */
    public AddRemovePage(PanelsManager manager) {
        //Basic setup for panel
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
        JLabel addRemoveLabel = new JLabel("Enter book information or remove a book via ISBN.");
        addRemoveLabel.setFont(new Font(fontFamily, Font.BOLD, 14));
        addRemoveLabel.setForeground(Color.white);

        // Search Field
        JTextField ISBNSearchField = new JTextField();
        ISBNSearchField.setBorder(fieldBorder);

        // Add Button
        JButton addButton = new JButton("Add a book");
        addButton.setBackground(Color.white);
        addButton.setForeground(Color.black);

        //Status message label
        JLabel bookInfoLabel = new JLabel();
        bookInfoLabel.setHorizontalAlignment(JLabel.CENTER);
        bookInfoLabel.setFont(new Font("Avenir", Font.BOLD, 14));
        bookInfoLabel.setForeground(Color.white);


        //Adding a book
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
                        bookInfoLabel.setText("Book added.");
                        addBook(book);
                    }
                } catch (Exception exc) {
                    System.out.println("invalid book");
                    bookInfoLabel.setText("Invalid book/Repeated ISBN.\nBook format is: Title, Author, ISBN, Genre");
                }

            }
        });

        // Remove Button
        JButton removeButton = new JButton("Remove a book");
        removeButton.setBackground(Color.white);
        removeButton.setForeground(Color.black);

        //Code for removing a book, assuming ISBN is valid, removes from Library using removeBook()
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book remBook = Library.searchByISBN(ISBNSearchField.getText());
                if (remBook!=null) {
                    System.out.println("removed book");
                    bookInfoLabel.setText("Removed book successfully.");
                    removeBook(remBook);
                }else{
                    bookInfoLabel.setText("Book not found.");
                }
            }
        });

        //Back button to get back to profile page
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
        add(removeButton);
        add(backButton);
        add(bookInfoLabel);
    }

    /**
     * Method to add a book to the library.
     * @param b the book to be added.
     */
    public static void addBook(Book b){
        Library.addBook(b);
    }

    /**
     * Method to remove a book from the library.
     * @param b the book to be removed.
     */
    public static void removeBook(Book b) {
        Library.removeBook(b);
    }
}
