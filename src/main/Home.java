package src.main;
import javax.swing.*;

import src.main.library.Book;
import src.main.library.Genre;
import src.main.library.Library;
import src.main.library.Status;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;

public class Home extends JPanel {
    private PanelsManager manager;
    private ArrayList<Component> previousComponents = new ArrayList<>();
    private static ArrayList<Book> books = Library.getInventory();

    // Linking front-end to Genre Enum
    Genre[] genres = Genre.values();


    private ArrayList<JButton> genreButtons = new ArrayList<>();

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

    public void addBooksFromFiles(){
        try{
            for (Genre genre : genres) {
                 String genreString = genre.toString();
                 String fileName = "src/files/books/" + genreString.toLowerCase() + ".txt";
                 Library.createList(fileName, genre, null);
            }
        } catch (IOException error) {
             System.out.println(error);
        }
    }

    public Home(PanelsManager manager) {
        this.manager = manager;

         addBooksFromFiles();

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
        
        // Borrow Button
        JButton borrowButton = new JButton("Borrow");
        borrowButton.setFont(new Font(fontFamily, Font.BOLD, 14));
        borrowButton.setHorizontalAlignment(JButton.CENTER);
        borrowButton.setBackground(Color.WHITE);

        // Return Button
        JButton returnButton = new JButton("Return");
        returnButton.setFont(new Font(fontFamily, Font.BOLD, 14));
        returnButton.setHorizontalAlignment(JButton.CENTER);
        returnButton.setBackground(Color.WHITE);

        // Back Button
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

        add(new JLabel());
        add(borrowButton);
        add(new JLabel());

        add(new JLabel());
        add(returnButton);
        add(new JLabel());


        for (Genre genre : genres) {
            String genreString = genre.toString();
            JButton genreButton = new JButton(genreString);
            genreButton.setFont(mainFont);
            genreButton.setHorizontalAlignment(JButton.CENTER);

            genreButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        removeAll();
                        validate();
                        repaint();

                        add(homeTitle);

                        for (Book book : books) {
                            if(book.getGenre().equals(genre)){
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
            manager.showSearchPanel();
        }
        });

        borrowButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            manager.showBorrowPage();
        }
        });


        returnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            manager.showReturnPage();
        }
        });
    }
}