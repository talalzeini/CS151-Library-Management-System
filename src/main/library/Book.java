package src.main.library;

/**Represents a Book object that users can add/remove, and borrow/return. */
public class Book {

    //Identifying fields for a Book
    private String ISBN;
    private String title;
    private String author;
    private Status status;
    private Genre genre;

    /**
     * Constructor for the Book class. Creates a Book object with a title, author, ISBN, genre, and checked-in status.
     * @param title The full title of the book.
     * @param author The full name of the author of the book.
     * @param ISBN The ISBN of the book.
     * @param genre The genre of the book, from an enumeration of pre-defined genres.
     * @param status Whether the book is checked in or borrowed.
     */
    public Book(String title, String author, String ISBN, Genre genre, Status status) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.status = status;
    }

    //Basic getters and setters
    public String getISBN(){
        return ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public Status geStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public Genre getGenre(){
        return genre;
    }
    
}