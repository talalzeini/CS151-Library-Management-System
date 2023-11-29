package src.main.library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**Represents the library as a whole, as a collection of Users and Books. */
public class Library {
    private static ArrayList<User> userList = new ArrayList<User>();
    private static ArrayList<Book> bookInventory = new ArrayList<Book>();

    /**
     * Method to add three example users, for test and demonstration purposes.
     */
    public static void addTestUser() {
        User testMember = new User("test", "test", Role.MEMBER, "test", "test", "test");
        User testAuthor = new User("author", "author", Role.AUTHOR, "author", "author", "author");
        User testLibrarian = new User("librarian", "librarian", Role.LIBRARIAN, "librarian", "librarian", "librarian");
        userList.add(testMember);
        userList.add(testAuthor);
        userList.add(testLibrarian);
    }

    /**
     * Method that adds a user to the list of users.
     * @param user The user to be added.
     */
    public static void addUser(User user){
        userList.add(user);
        writeLibraryCardIDToFile(user);
    }

    /**
     * Method to store a user's unique library card ID.
     * @param user the user whose ID will be stored.
     */
    private static void writeLibraryCardIDToFile(User user) {
        
        String userRoleString= user.getRole().toString();
        System.out.println(userRoleString);
    
        try (FileWriter writer = new FileWriter("src/files/users/" + userRoleString + "s.txt", true)) {
            writer.write(user.getLibraryCardID() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getUsers() {
        return userList;
    }

    public static ArrayList<Book> getInventory(){
        return bookInventory;
    }

    public ArrayList<User> getUserList(){
        return userList;
    }

    public void removeUser(User user){
        userList.remove(user);
    }

    public static void addBook(Book b){
        bookInventory.add(b);
    }

    public static void removeBook(Book b){
        bookInventory.remove(b);
    }

    /**
     * Method that creates a list of all books available in the library.
     * The method takes input from a formatted file containing the information of all books to be added.
     * @param filename
     * @param genre
     * @param status
     * @throws IOException
     */
    public static void createList(String filename, Genre genre, Status status) throws IOException {
        try (FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(","); // Assuming data is comma-separated

                // Extracting information to create a Book object
                String title = bookData[0];
                String author = bookData[1];
                String ISBN = bookData[2]; // Assuming ISBN is the third element
                String stringStatus = bookData[3].trim();

                boolean isCheckedIn = Boolean.parseBoolean(stringStatus);

                // Create a book object and add it to the list
                Book book = new Book(title, author, ISBN, genre, isCheckedIn ? Status.CHECKED_IN : Status.CHECKED_OUT);
                Library.addBook(book);
            }
        }
    }

    /**
     * Method that searches for a book by its title.
     * @param title a string key that will be searched for.
     * @return an ArrayList of Books with titles containing the search key.
     */
    public static ArrayList<Book> searchByTitle(String title){
        ArrayList<Book> returnal = new ArrayList<Book>();
        for(Book b : bookInventory){
            if(b.getTitle().toLowerCase().contains(title.toLowerCase())){
                returnal.add(b);
            }
        }
        return returnal;
    }

    /**
     * Method that searches for a book by exact ISBN
     * @param ISBN the ISBN of the book to be searched for.
     * @return The book being searched for if it exists, otherwise null.
     */
    public static Book searchByISBN(String ISBN){
        for(Book book : bookInventory){
            if (book.getISBN().trim().equals(ISBN.trim())) {
                return book;
            }
        }
        return null;
    }
    
}