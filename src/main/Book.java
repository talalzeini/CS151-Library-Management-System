package src.main;

import java.io.File;

/**Describes a book in the library. */
public class Book {

    private int ISBN;
    private String title;
    private String author;
    private File content;
    private Status status;
    private int libraryID;
    private static int libraryIDCounter = 0;


    public Book(String t, String a, int num, File content) {
        title = t;
        author = a;
        ISBN = num;
        this.content = content;
        this.status = Status.CHECKED_IN;
        libraryID = libraryIDCounter;
        libraryIDCounter ++;
    }

    public int getISBN(){
        return ISBN;
    }

    public void setISBN(int ISBN){
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


    
}