import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements MouseListener {

    JLabel label;
    ImageIcon icon[] = new ImageIcon[5];

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());

        icon[0] = new ImageIcon("akhri-salami.png");
        icon[1] = new ImageIcon("glass-wala.png");
        icon[2] = new ImageIcon("looking-at-gandu.png");
        icon[3] = new ImageIcon("omg.png");
        icon[4] = new ImageIcon("pagol-sagol.png");

        label = new JLabel();
        label.setIcon(icon[1]);
        label.addMouseListener(this);

        this.add(label);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        // invoke when mouse button is clicked(pressed and released) on a component
        // System.out.println("Clicked");
        label.setIcon(icon[3]);
    }

    @Override
    public void mousePressed(MouseEvent e){
        // invoke when mouse button is pressed on a component
        // System.out.println("Pressed");
        label.setIcon(icon[0]);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        // invoke when mouse button is released on a component
        // System.out.println("Released");
        label.setIcon(icon[3]);
    }

    @Override
    public void mouseEntered(MouseEvent e){
        // when mouse enters a component
        // System.out.println("Entered");
        label.setIcon(icon[2]);
    }

    @Override
    public void mouseExited(MouseEvent e){
        // when mouse exits a component
        // System.out.println("Exited");
        label.setIcon(icon[4]);
    }

    
}
