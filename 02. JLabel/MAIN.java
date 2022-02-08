import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class MAIN{
    public static void main(String[] args) {
        
        ImageIcon img = new ImageIcon("dude.png");
        Border border = BorderFactory.createLineBorder(Color.green, 3);

        JLabel label = new JLabel(); // A display area for a string text, an image or both
        label.setText(" Sami is dumb ");
        label.setIcon(img);
        label.setHorizontalTextPosition(JLabel.CENTER); // LEFT,RIGHT of image icon
        label.setVerticalTextPosition(JLabel.BOTTOM); // TOP, CENTER of image icon
        
        label.setForeground(new Color(0x123456)); // set text color.....
        label.setFont(new Font("MV Boli", Font.PLAIN, 40));
        label.setIconTextGap(-15);
        
        label.setBackground(new Color(0,0,0));
        label.setOpaque(true); // shows background 
        
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        // label.setBounds(0, 0, 300, 300); // x,y, width, height   1

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(600, 400); // 1
        // frame.setLayout(null);  // 1 
        frame.setVisible(true);
        frame.add(label);
        frame.pack(); // to use this comment , 1
    }
}