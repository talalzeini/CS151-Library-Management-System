package src.main;

import java.util.ArrayList;

/*A collection of books accessible to users, editable by librarians */
public class Library {

    private ArrayList<User> userList = new ArrayList<User>();

    private ArrayList<Book> bookInventory = new ArrayList<Book>();



    public ArrayList<Book> getInventory(){
        return bookInventory;
    }

    public ArrayList<User> getUserList(){
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
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

    /*Returns a list of books containing the given name in the title */
    public ArrayList<Book> searchByName(String name){
        ArrayList<Book> returnal = new ArrayList<Book>();
        for(Book b : bookInventory){
            if(b.getTitle().contains(name)){
                returnal.add(b);
            }
        }
        return returnal;
    }

    /*Returns a book with ISBN if it exists, null otherwise. */
    public Book searchByISBN(int ISBN){
        for(Book b : bookInventory){
            if(b.getISBN() == ISBN){
                return b;
            }
        }
        return null;
    }
    
}