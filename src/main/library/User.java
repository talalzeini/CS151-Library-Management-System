package src.main.library;
import java.util.ArrayList;

/** Desribes a user of the library system who reads and discusses books online. */
public class User {
    
    /** Name of the user, typically consisting of the First, Last, and libraryCardID. */

    private String firstName;
    private String lastName;
    private Role role;
    private String libraryCardID;
    /** The set of all books currently borrowed by the user. */
    private ArrayList<Book> borrowedBooks;
    /** The password of each user, to log into an account. */
    private String password;
    /** The email of the user used for all contact. If a user has multiple emails,
     *  use the one selected for library communications. */
    private String email;

      public User(String firstName, String lastName, Role role, String libraryCardID, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
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

    // Getters and setters for the fields
    public Role getRole() {
        return role;
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

    public ArrayList<Book> getBorrowedBooks(){
        return borrowedBooks;
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