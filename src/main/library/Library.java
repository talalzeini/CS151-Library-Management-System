package src.main.library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private static ArrayList<User> userList = new ArrayList<User>();
    private static ArrayList<Book> bookInventory = new ArrayList<Book>();

    public static void addTestUser() {
        User testUser = new User("test", "test", "test", "test", "test", "test");
        userList.add(testUser);
    }

    public static void addUser(User user){
        userList.add(user);
        writeLibraryCardIDToFile(user);
    }

    public static String getRoleFile(String userRole){
        if(userRole.toLowerCase().equals("member")){
            return "members";
        }
        else if(userRole.toLowerCase().equals("author")){
            return "authors";
        }
        else if(userRole.toLowerCase().equals("librarian")){
            return "librarians";
        }
        return "";
    }

    private static void writeLibraryCardIDToFile(User user) {
        
        String userRole = user.getRole();
        System.out.println(userRole);
         String roleFileString = getRoleFile(userRole);
          System.out.println(roleFileString);
    
        try (FileWriter writer = new FileWriter("src/files/users/" + roleFileString + ".txt", true)) {
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

    public void removeBook(Book b){
        bookInventory.remove(b);
    }

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
    
    /* Returns a list of books containing the given name in the title */
    public static ArrayList<Book> searchByTitle(String title){
        ArrayList<Book> returnal = new ArrayList<Book>();
        for(Book b : bookInventory){
            if(b.getTitle().toLowerCase().contains(title.toLowerCase())){
                returnal.add(b);
            }
        }
        return returnal;
    }

    /* Returns a book with ISBN if it exists, null otherwise. */
    public static Book searchByISBN(String ISBN){
        for(Book book : bookInventory){
            if (book.getISBN().trim().equals(ISBN.trim())) {
                return book;
            }
        }
        return null;
    }
    
}