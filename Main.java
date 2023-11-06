
import javax.swing.*;
import src.main.*;

public class Main {
    public static void main(String[] args) {
            JFrame frame = new JFrame("CS151-Library-Management-System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            PanelsManager manager = new PanelsManager();
            frame.add(manager);
            frame.setVisible(true);
    }
}
