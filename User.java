import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.EnumSet;

/**Desribes a user of the library system who reads and discusses books online. */
public class User {
    
    /**Name of the user, typically consisting of the First, Last, and if applicable, Middle name. */
    private String name;
    /**The numeric individual ID of each user. */
    private int userID;
    /**The set of all books currently borrowed by the user. */
    private Book[] borrowedBooks;
    /**The password of each user, to log into an account. */
    private String password;
    /**The email of the user used for all contact. If a user has multiple emails,
     *  use the one selected for library communications. */
    private String email;
    /**The set of the user's favorited books. */
    ArrayList<Book> favoriteBooks;
    /**Set of the user's favorite Genres*/
    EnumSet<Genre> favoriteGenres;
    /**Set of the user's favorite topics */
    EnumSet<Topic> favoriteTopics;
    /**Set of the user's favorite authors */
    ArrayList<Author> favoriteAuthors;
    /**Basic decription of the user, written by the user. */
    String summary;
    /**Profile Picture in some kind of image form. */
    File profilePicture;
    /**The amount of total dues due to late fees and other offenses. */
    int debt;
    /**A set of books that a user would like to read in the future.*/
    ArrayList<Book> wishList;
    /**A list of reviews that this user has posted */
    ArrayList<Review> reviews;

    public void createList(String filename) throws FileNotFoundException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        // tbd line-by-line -> book objects

    }

    public void borrowBook(){

    }

    public void returnBook(){

    }
}