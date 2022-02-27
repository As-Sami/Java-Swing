
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class SamFrame extends JFrame{
    
    SamFrame(){
        this.setVisible(true);
        this.setTitle("Sami's second GUI");
        this.setSize(560, 450);

        ImageIcon image = new ImageIcon("hiakymaru.jpg"); // crate an image
		this.setIconImage(image.getImage());

        this.getContentPane().setBackground(new Color(0x123456) ); 
    }
}
