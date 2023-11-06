
import javax.swing.*;
import src.main.*;

public class Main {
    public static void main(String[] args) {
            JFrame frame = new JFrame("CS151-Library-Management-System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);

            PanelsManager manager = new PanelsManager();
            frame.add(manager);
            frame.setVisible(true);
    }
}
