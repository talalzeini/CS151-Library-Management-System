package src.main.library;
import java.util.ArrayList;
/** Desribes a user of the library system who reads and discusses books online. */
public class User {
    
    /** Name of the user, typically consisting of the First, Last, and libraryCardID. */
    private String firstName;
    private String lastName;
    private String libraryCardID;
    /** The set of all books currently borrowed by the user. */
    private ArrayList<Book> borrowedBooks;
    /** The password of each user, to log into an account. */
    private String password;
    /** The email of the user used for all contact. If a user has multiple emails,
     *  use the one selected for library communications. */
    private String email;
    /** The set of the user's favorited books. */
    // ArrayList<Book> favoriteBooks;
    /** Set of the user's favorite Genres*/
    // EnumSet<Genre> favoriteGenres;
    /** Set of the user's favorite topics */
    // EnumSet<Topic> favoriteTopics;
    /** Set of the user's favorite authors */
    // ArrayList<Author> favoriteAuthors;
    /** Basic decription of the user, written by the user. */
    // String summary;
    /** Profile Picture in some kind of image form. */
    // File profilePicture;
    /** The amount of total dues due to late fees and other offenses. */
    // int debt;
    /** A set of books that a user would like to read in the future.*/
    // ArrayList<Book> wishList;
    /** A list of reviews that this user has posted */
    // ArrayList<Review> reviews;

    // public ArrayList<Book> createList(String filename) throws IOException {
    //     ArrayList<Book> books = new ArrayList<>();

    //     try (FileReader fr = new FileReader(filename);
    //          BufferedReader br = new BufferedReader(fr)) {

    //         String line;
    //         while ((line = br.readLine()) != null) {
    //             String[] bookData = line.split(","); // Assuming data is comma-separated

    //             // Extracting information to create a Book object
    //             String title = bookData[0];
    //             String author = bookData[1];
    //             int ISBN = Integer.parseInt(bookData[2]); // Assuming ISBN is the third element

    //             // Create a book object and add it to the list
    //             Book book = new Book(title, author, ISBN, null); // 'null' for content, assuming it's not read in this function
    //             books.add(book);
    //         }
    //     }

    //     return books;
    // }



      public User(String firstName, String lastName, String libraryCardID, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.libraryCardID = libraryCardID;
        this.email = email;
        this.password = password;
    }

    // Getters and setters for the fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLibraryCardID() {
        return libraryCardID;
    }

    public void setLibraryCardID(String libraryCardID) {
        this.libraryCardID = libraryCardID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* Check out a book, adds book in paramter to borrowedBooks */
    public void borrowBook(Book b){
        borrowedBooks.add(b);
    }

    /* Return a book, removes book in paramter from borrowedBooks */
    public void returnBook(Book b){
        borrowedBooks.remove(b);
    }
}