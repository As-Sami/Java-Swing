import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class MAIN {
    public static void main(String[] args) {
        // JLayeredPane = Swing container that provides a third dimension
        // for positioning components ex. depth, Z-index

        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setBounds(50, 50, 200, 200);

        JLabel label2 = new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.green);
        label2.setBounds(100, 100, 200, 200);

        JLabel label3 = new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.blue);
        label3.setBounds(150, 150, 200, 200);

        JLayeredPane lpane = new JLayeredPane();
        lpane.setBounds(0, 0, 500, 500);
        lpane.add(label1, Integer.valueOf(0) ); // we can use JLayeredPane.DEFAULT_LAYER <
        lpane.add(label2, Integer.valueOf(2) ); // PALETTE_LAYER < MODAL_LAYER < POPUP_LAYER 
        lpane.add(label3, Integer.valueOf(1) ); //  < DRAG_LAYER

        JFrame frame = new JFrame("JLayeredPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);

        frame.add(lpane);

        frame.setVisible(true);
    }
}
