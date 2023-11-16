
import javax.swing.*;
import src.main.*;

/**The class that contains the main method to start the program. */
public class Main {
    public static void main(String[] args) {

            //Creates the JFrame that contains all individual modules
            JFrame frame = new JFrame("CS151-Library-Management-System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);

            //Instantiates a PanelsManager that populates the Frame and handles user input.
            PanelsManager manager = new PanelsManager();
            frame.add(manager);
            frame.setVisible(true);
    }
}
