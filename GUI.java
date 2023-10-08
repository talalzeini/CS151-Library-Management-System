import javax.swing.*;

import org.w3c.dom.Text;

import java.awt.*;

public class GUI {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame();
        frame.setBounds(500, 500, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("CS151-Library-Management-System");
        frame.getContentPane().setBackground(Color.BLUE);

        JLabel label = new JLabel();
        label.setText("Welcome");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.white);

        frame.add(label);
        frame.setVisible(true);
      
    }
}