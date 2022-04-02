import javax.swing.JFrame;

public class Frame1 extends JFrame{
    public Frame1(){
        setTitle("Frame1");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout());

        setVisible(true);
    }
}
