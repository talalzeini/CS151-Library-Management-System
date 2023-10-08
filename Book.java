
public class Book {

    private int ISBN;
    private String title;
    private String author;


    enum Status {
        CHECKED_IN,
        CHECKED_OUT
    }

    public Book(String t, String a, int num) {
        title = t;
        author = a;
        ISBN = num;
    }

    
}