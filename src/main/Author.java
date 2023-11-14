package src.main;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**Describes an author of a book.*/
public class Author {

    private String name;

    private ArrayList<Book> publishedBooks;
    private ArrayList<Genre> publishedGenres;
    private ArrayList<Topic> publishedTopics;
    private ArrayList<Author> favoriteAuthors;
    private ArrayList<Book> favoriteBooks;
    private ArrayList<Genre> favoriteGenres;
    private ArrayList<Topic> favoriteTopics;


    private int summary;
    private File profilePicture; //directory + icon?

    private ArrayList<User> favoritedBy;

    public Author(String name){
        this.name = name;
        publishedBooks = new ArrayList<>();
        favoriteBooks = new ArrayList<>();
        favoriteAuthors = new ArrayList<>();
        favoriteGenres = new ArrayList<>();
        favoriteTopics = new ArrayList<>();
        publishedGenres = new ArrayList<>();
        publishedTopics = new ArrayList<>();
    }

    public Author(String name,
                  ArrayList<Book> published,
                  ArrayList<Genre> publishGenre,
                  ArrayList<Topic> publishTopics,
                  ArrayList<Book> favBook,
                  ArrayList<Author> favAuthor,
                  ArrayList<Genre> favGenre,
                  ArrayList<Topic> favTopics,
                  int sum, File profilePic){
        this.name = name;
        publishedBooks = published;
        publishedGenres = publishGenre;
        publishedTopics = publishTopics;
        favoriteAuthors = favAuthor;
        favoriteBooks = favBook;
        favoriteGenres = favGenre;
        favoriteTopics = favTopics;
        summary = sum;
        profilePicture = profilePic;

    }

    public Book addBook(Book b){
        publishedBooks.add(b);
        return b;
    }

    public void addPublishedGenre(Genre g){
        publishedGenres.add(g);
    }
    public void addPublishedTopic(Topic t) {
        publishedTopics.add(t);
    }
    public void addFavoriteBook(Book fb) {
        favoriteBooks.add(fb);
    }

    public void removeFavoriteBook(Book fb) {
        favoriteBooks.remove(fb);
    }

    public void addFavoriteGenre(Genre g){
        favoriteGenres.add(g);
    }

    public void removeFavoriteGenre(Genre g){
        favoriteGenres.remove(g);
    }

    public void addFavoriteTopic(Topic t) {
        favoriteTopics.add(t);
    }

    public void removeFavoriteTopic(Topic t) {
        favoriteTopics.remove(t);
    }

    public void addFavoriteAuthor(Author a){
        favoriteAuthors.add(a);
    }
    public void removeFavoriteAuthor(Author a){
        favoriteAuthors.remove(a);
    }

    /**
     * what is this method?
     */
    public void addLikes(User u) {

    }

    public void addFavoritedUser(User u){
        favoritedBy.add(u);
    }

    public ArrayList<User> getFavoritedUsers(User u){
        return favoritedBy;
    }


    @Override
    public String toString() {
        return name;
    }

}