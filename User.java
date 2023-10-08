import com.sun.management.OperatingSystemMXBean;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.*;

public class User {

    private String userName;
    private int libraryCard;
    private Book[] borrowedBooks;

    public void createList(String filename) throws FileNotFoundException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        // tbd line-by-line -> book objects

    }

    public void borrowBook(){

    }

    public void returnBook(){

    }
}