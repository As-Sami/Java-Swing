import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MyFrame extends JFrame implements ActionListener{
    JRadioButton button1,button2,button3;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button1 = new JRadioButton("Pizza");
        button2 = new JRadioButton("Burger");
        button3 = new JRadioButton("Hot Dog");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        ButtonGroup grp = new ButtonGroup();
        grp.add(button1);
        grp.add(button2);
        grp.add(button3);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if( e.getSource()==button1 ){
            System.out.println("You ordered pizza");
        }else if( e.getSource()==button2 ){
            System.out.println("You ordered burger");
        }else if( e.getSource()==button3 ){
            System.out.println("You ordered Hog Dog");
        }
    }
}
