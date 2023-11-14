package src.main.library;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**Describes an author of a book.*/
public class Author {

    private String name;

    private ArrayList<Book> publishedBooks;
    private ArrayList<Book> favoriteBooks;
    private ArrayList<Author> favoriteAuthor;
    private ArrayList<Genre> favoriteGenres;
    private ArrayList<Topic> favoriteTopics;
    private ArrayList<Genre> publishedGenres;
    private ArrayList<Genre> publishedTopics;

    private int summary;
    private File profilePicture; //directory + icon?

    private ArrayList<User> favoritedBy;

    public Author(String name){
        this.name = name;
        publishedBooks = new ArrayList<>();
    }

    public Book addBook(Book b){
        publishedBooks.add(b);
        return b;
    }

    public void addFavoriteBook(Book fb) {

    }

    public void removeFavoriteBook(Book fb) {

    }


    @Override
    public String toString() {
        return name;
    }

}
