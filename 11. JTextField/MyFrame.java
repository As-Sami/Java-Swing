import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
    JButton button;
    JTextField txf;

    MyFrame(){
        button = new JButton("Submit");
        button.addActionListener(this);

        txf = new JTextField();
        txf.setPreferredSize(new Dimension(250,40));
        txf.setFont(new Font("Consolas", Font.PLAIN, 35));
        txf.setForeground(Color.GRAY);
        txf.setBackground(Color.BLACK);
        txf.setCaretColor(Color.WHITE);

        this.add(button);
        this.add(txf);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            System.out.println(txf.getText());
            txf.setEditable(false);
            button.setEnabled(false);
        }
    }
}
