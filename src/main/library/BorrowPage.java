package src.main.library;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.border.Border;
import src.main.PanelsManager;
import java.awt.*;

public class BorrowPage extends JPanel {

        private static String statusMessage;

    /**
     * Static method that updates the checked-in-out status of a borrowed book.
     * @param genre The genre of the book.
     * @param isbn The ISBN of the book.
     * @param newStatus The new status of the book. A book can be checked in or checked out.
     * @throws IOException Exception handling for if a book is not found from the database of books.
     */
        public static void updateBorrowedBookStatus(Genre genre, String isbn, Status newStatus) throws IOException {
        String genreString = genre.toString();
        String filename = "src/files/books/" + genreString.toLowerCase() + ".txt";
        File file = new File(filename);

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("Genre file not found: " + genre);
            return;
        }

        // Read the file and update the status
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            StringBuilder updatedContent = new StringBuilder();
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(",");
                String currentISBN = bookData[2].trim();

                if (currentISBN.equals(isbn.trim())) {
                    // Update the status
                    bookData[3] = Boolean.toString(newStatus == Status.CHECKED_IN);
                    found = true;
                }

                // Reconstruct the line
                updatedContent.append(String.join(",", bookData)).append("\n");
            }

            // If book with the given ISBN is not found, print a message
            if (!found) {
                System.out.println("Book with ISBN " + isbn + " not found in the " + genre + " genre.");
                return;
            }

            // Write the updated content back to the file
            try (FileWriter fw = new FileWriter(file);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                bw.write(updatedContent.toString());
            }

            System.out.println("Status updated successfully.");
        }
    }


    /**
     * Method that borrows a book with a given ISBN.
     * The method updates the status of a book if it is in the library (not borrowed).
     * @param searchedText The ISBN of the book to borrow.
     * @return a status message displaying whether the book was successfully borrowed or not.
     */
    public static String borrowBookNow(String searchedText) {

    // Trim the input string
    String trimmedISBN = searchedText.trim();

    String bookString = "";
    // Check if the trimmed string is a number
    if (trimmedISBN.matches("\\d+")) {
        // It's a number, proceed with searching
        Book searchedBook = Library.searchByISBN(trimmedISBN);

        // Check if the book is found
        if (searchedBook != null) {
                if(searchedBook.geStatus() == Status.CHECKED_IN){
                    try{
                        String bookISBN =  searchedBook.getISBN();
                        bookString = "You succesfully borrowed the book with ISBN: " + bookISBN;
                        searchedBook.setStatus(Status.CHECKED_OUT); 
                        Genre genreOfBook = searchedBook.getGenre();
                        updateBorrowedBookStatus(genreOfBook, bookISBN, Status.CHECKED_OUT);

                    }catch (IOException error) {
                        System.out.println(error);
                    }
            }else if(searchedBook.geStatus() == Status.CHECKED_OUT){
                bookString = "Apologies. This book is already borrowed by someone else. (or you)";
            }
        } else {
             // No books found for the entered ISBN
             bookString = "Book not found for ISBN: " + trimmedISBN;
        }


    } else {
        bookString = "Invalid Input. You need to enter the ISBN";
    }
        return bookString;
    }


    public PanelsManager manager;

    /**
     * Constructor for the book borrowing page.
     * @param manager The PanelsManager object controlling the UI components of the page.
     */
    public BorrowPage(PanelsManager manager){{
        this.manager = manager;

        statusMessage = "";

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(600, 600);
        setLayout(new GridLayout(13, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // App Label
        JLabel mainTitle = new JLabel("Looking for a new Book?");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        mainTitle.setForeground(Color.white);

        JLabel borrowLabel = new JLabel("Enter your book's ISBN here:");
        borrowLabel.setFont(new Font(fontFamily, Font.BOLD, 14));
        borrowLabel.setForeground(Color.white);

        // ISBN Search Field
        JTextField ISBNSearchField = new JTextField();
        ISBNSearchField.setBorder(fieldBorder);

        // Borrow Button
        JButton borrowButton = new JButton("Borrow");
        borrowButton.setBackground(Color.white);
        borrowButton.setForeground(Color.black);

        //Status message label
        JLabel bookInfoLabel = new JLabel(statusMessage);
        bookInfoLabel.setHorizontalAlignment(JLabel.CENTER);
        bookInfoLabel.setFont(new Font("Avenir", Font.BOLD, 14));
        bookInfoLabel.setForeground(Color.white);

        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchedText = ISBNSearchField.getText();
                System.out.println("Borrowing....");
                statusMessage = borrowBookNow(searchedText);
                bookInfoLabel.setText(statusMessage);
                validate();
                 repaint();
            }
        });


        //Back button to return to last page.
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
        add(borrowLabel);
        add(ISBNSearchField);
        add(borrowButton);
        add(backButton);
        add(bookInfoLabel);
    }
}
}