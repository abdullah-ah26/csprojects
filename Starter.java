package lab1;
import javax.swing.*;
import java.awt.*;

public class Starter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("The Frame We See");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(800,600));
        mainPanel.setBackground(Color.blue);
        frame.getContentPane().add(mainPanel);
        frame.pack();

        DrawingPanel dPanel = new DrawingPanel();
        dPanel.setPreferredSize(new Dimension(600,600));
        dPanel.setBackground(Color.white);
        mainPanel.add(dPanel);

        Timer t = new Timer(20,dPanel);
        t.start();
        
        frame.pack();
    }
}