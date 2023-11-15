package src.main.library;

public class Book {

    private String ISBN;
    private String title;
    private String author;
    private Status status;
    private Genre genre;

    public Book(String title, String author, String ISBN, Genre genre, Status status) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.status = status;
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