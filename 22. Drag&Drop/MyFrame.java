import javax.swing.JFrame;

public class MyFrame extends JFrame {

    DragPanel panel;

    MyFrame(){
        panel = new DragPanel();

        this.add(panel);
        this.setTitle("Drag and Drop");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
