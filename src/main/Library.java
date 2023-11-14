package src.main;
import java.util.ArrayList;

public class Library {
    private static ArrayList<User> userList = new ArrayList<User>();
    private ArrayList<Book> bookInventory = new ArrayList<Book>();

    public static void addTestUser() {
        User testUser = new User("test", "test", "test", "test", "test");
        userList.add(testUser);
    }

    public static void addUser(User user){
        userList.add(user);
    }

    public static ArrayList<User> getUsers() {
        return userList;
    }

    public ArrayList<Book> getInventory(){
        return bookInventory;
    }

    public ArrayList<User> getUserList(){
        return userList;
    }

    public void removeUser(User user){
        userList.remove(user);
    }

    public void addBook(Book b){
        bookInventory.add(b);
    }

    public void removeBook(Book b){
        bookInventory.remove(b);
    }

    /* Returns a list of books containing the given name in the title */
    public ArrayList<Book> searchByName(String name){
        ArrayList<Book> returnal = new ArrayList<Book>();
        for(Book b : bookInventory){
            if(b.getTitle().contains(name)){
                returnal.add(b);
            }
        }
        return returnal;
    }

    /* Returns a book with ISBN if it exists, null otherwise. */
    public Book searchByISBN(String ISBN){
        for(Book b : bookInventory){
            if(b.getISBN() == ISBN){
                return b;
            }
        }
        return null;
    }
    
}