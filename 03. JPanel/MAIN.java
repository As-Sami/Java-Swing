import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MAIN {
    public static void main(String[] args) {
        
        // JPanel - a gui component that functions as a container to hold other component
        ImageIcon icon = new ImageIcon("what.png");

        JLabel label = new JLabel();
        label.setText("Foolish Sami");
        label.setIcon(icon);
        // label.setHorizontalAlignment(JLabel.RIGHT); // you dont need these 2 if you dont
        // label.setVerticalAlignment(JLabel.BOTTOM); // use borderlayout
        label.setBounds(50,50, 250, 200);

        JPanel redPanel = new JPanel(); 
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);
        redPanel.setLayout(null);

        JPanel bluePanel = new JPanel(); 
        bluePanel.setBackground(Color.blue);
        bluePanel.setBounds(250, 0, 250, 250);
        bluePanel.setLayout(null);

        JPanel greenPanel = new JPanel(); 
        greenPanel.setBackground(Color.green);
        greenPanel.setBounds(0, 250, 500, 250);
        // greenPanel.setLayout(new BorderLayout());
        greenPanel.setLayout(null);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(750, 750);
        frame.setVisible(true);

        greenPanel.add(label);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
    }
}
