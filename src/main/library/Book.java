package src.main.library;

import java.io.File;

/**Describes a book in the library. */
public class Book {

    private String ISBN;
    private String title;
    private String author;
    private File content;
    private Status status;
    private Genre genre;
    private int libraryID;
    private static int libraryIDCounter = 0;


    public Book(String t, String a, String num, Genre genre, File content) {
        title = t;
        author = a;
        ISBN = num;
        this.genre = genre;
        this.content = content;
        this.status = Status.CHECKED_IN;
        libraryID = libraryIDCounter;
        libraryIDCounter ++;
    }

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

    public File read(){
        return content;
    }

    public void setContent(File content){
        this.content = content;
    }

    public Status geStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public int getID(){
        return libraryID;
    }

    public Genre getGenre(){
        return genre;
    }

    
}