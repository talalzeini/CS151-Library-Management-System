package src.main;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;

public class Home extends JPanel {
    private PanelsManager manager;
     private ArrayList<Component> previousComponents = new ArrayList<>();

    // Linking front-end to Genre Enum
    Genre[] genres = Genre.values();

    private ArrayList<JButton> genreButtons = new ArrayList<>();

     public ArrayList<Book> createList(String filename) throws IOException {
        ArrayList<Book> books = new ArrayList<>();

        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(","); // Assuming data is comma-separated

                // Extracting information to create a Book object
                String title = bookData[0];
                String author = bookData[1];
                String ISBN = bookData[2]; // Assuming ISBN is the third element

                // Create a book object and add it to the list
                Book book = new Book(title, author, ISBN, null); // 'null' for content, assuming it's not read in this function
                books.add(book);
            }
        }

        return books;
    }


    public void showGenreInfo(String genreString, JButton openProfileButton, JLabel homeTitle){
        openProfileButton.setVisible(false);
        homeTitle.setText(genreString + " Books");
        for (JButton button : genreButtons) {
            remove(button);
            button.setVisible(false);
        }
        validate();
        repaint();
    }

    public Home(PanelsManager manager) {



        this.manager = manager;

        String fontFamily = "Avenir";
        Font mainFont = new Font(fontFamily, Font.PLAIN, 14);
        
        setSize(600, 600);
        setLayout(new GridLayout(14, 3));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Home Title Label
        JLabel homeTitle = new JLabel("Welcome to LMS");
        homeTitle.setHorizontalAlignment(JLabel.CENTER);
        homeTitle.setFont(new Font(fontFamily, Font.BOLD, 20));
        homeTitle.setForeground(Color.white);

        // Profile Button
        JButton openProfileButton = new JButton("My Profile");
        openProfileButton.setFont(new Font(fontFamily, Font.BOLD, 18));
        openProfileButton.setHorizontalAlignment(JButton.CENTER);
        openProfileButton.setBackground(Color.WHITE);
        openProfileButton.setForeground(Color.red);

        // Search Button
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font(fontFamily, Font.BOLD, 18));
        searchButton.setHorizontalAlignment(JButton.CENTER);
        searchButton.setBackground(Color.WHITE);
        searchButton.setForeground(Color.red);

        // Add a "Back" button
        JButton backButton = new JButton("Back");
        backButton.setFont(mainFont);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                      removeAll();

        // Restore the previous components
        for (Component component : previousComponents) {
            add(component);
            component.setVisible(true);
            homeTitle.setText("Welcome to LMS");
        }

        validate();
        repaint();
            }
        });
        
        add(new JLabel());
        add(homeTitle);
        add(new JLabel());


        add(new JLabel());
        add(openProfileButton);
        add(new JLabel());

         add(new JLabel());
         add(searchButton);
        add(new JLabel());

        for (Genre genre : genres) {
            String genreString = genre.toString();
            JButton genreButton = new JButton(genreString);
            genreButton.setFont(mainFont);
            genreButton.setHorizontalAlignment(JButton.CENTER);

            genreButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        removeAll();
                        validate();
                        repaint();

                        add(homeTitle);

                        ArrayList<Book> books = createList("src/files/books/" + genreString.toLowerCase() + ".txt");

                        for (Book book : books) {
                            String bookTitle = book.getTitle();
                            String bookAuthor = book.getAuthor();
                            String bookISBN = book.getISBN();
                            String bookInfoString = bookTitle + ", " + bookAuthor + ", " + bookISBN;
                            JLabel bookInfoLabel = new JLabel(bookInfoString);
                            add(bookInfoLabel);
                            bookInfoLabel.setForeground(Color.white);
                            bookInfoLabel.setHorizontalAlignment(JLabel.CENTER);
                            showGenreInfo(genreString, openProfileButton, homeTitle);
                            add(backButton);
                        }

                    } catch (IOException error) {
                        // System.out.println(error);
                    }
                }
            });
            
            genreButtons.add(genreButton); 
            add(new JLabel());
            add(genreButton);
            add(new JLabel());

            previousComponents.clear();
            for (Component component : getComponents()) {
                previousComponents.add(component);
            }

        }

        openProfileButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            manager.showProfilePanel();
        }
        });


        searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            manager.showProfilePanel();
        }
        });
    }
}