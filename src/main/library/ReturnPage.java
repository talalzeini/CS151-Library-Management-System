package src.main.library;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import src.main.PanelsManager;
import java.awt.*;

public class ReturnPage extends JPanel {


    public static void updateReturnedBookStatus(Genre genre, String isbn, Status newStatus) throws IOException {
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




    public static JLabel returnBookNow(String searchedText) {

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
            String bookString = "";
           System.out.print(searchedBook.geStatus()) ;
             System.out.print(Status.CHECKED_OUT) ;
            if(searchedBook.geStatus() == Status.CHECKED_OUT){

                try{

                    String bookISBN = searchedBook.getISBN();
                    bookString = "You succesfully returned the book with ISBN: " + bookISBN;
                    searchedBook.setStatus(Status.CHECKED_IN); 
                    Genre genreOfBook = searchedBook.getGenre();
                    updateReturnedBookStatus(genreOfBook, bookISBN, Status.CHECKED_IN);
                }catch (IOException error) {
             System.out.println(error);
            }

            }else if(searchedBook.geStatus() == Status.CHECKED_IN){
                bookString = "Apologies. You can't return this book because you never borrowed it.";
            }
            bookInfo.setText(bookString);
        } else {
             // No books found for the entered ISBN
             bookInfo.setText("Book not found for ISBN: " + trimmedISBN);
        }
    } else {
        bookInfo.setText("Invalid Input. You need to enter the ISBN");
    }
        return bookInfo;
    }


    public PanelsManager manager;
    public ReturnPage(PanelsManager manager){{
        this.manager = manager;

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        Border fieldBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setSize(600, 600);
        setLayout(new GridLayout(13, 2));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // App Label
        JLabel mainTitle = new JLabel("Looking to return a Book?");
        mainTitle.setHorizontalAlignment(JLabel.CENTER);
        mainTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        mainTitle.setForeground(Color.white);

        // Return Label
        JLabel returnLabel = new JLabel("Enter your book's ISBN here: ");
        returnLabel.setFont(new Font(fontFamily, Font.BOLD, 14));
        returnLabel.setForeground(Color.white);

        // Search Field
        JTextField ISBNSearchField = new JTextField();
        ISBNSearchField.setBorder(fieldBorder);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setBackground(Color.white);
        returnButton.setForeground(Color.black);

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchedText = ISBNSearchField.getText();
                System.out.println("Returning....");
                JLabel bookInfoLabel = returnBookNow(searchedText);
                 add(bookInfoLabel);
                validate();
                 repaint();
            }
        });

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
        add(ISBNSearchField);
        add(returnButton);
        add(backButton);
    }
}
}