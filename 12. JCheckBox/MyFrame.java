import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class MyFrame extends JFrame implements ActionListener{
    
    JButton button;
    JCheckBox box;
    ImageIcon crossIcon, checkIcon;
    
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        crossIcon = new ImageIcon("cross.png");
        checkIcon = new ImageIcon("check.png");

        button = new JButton("Submit");
        button.addActionListener(this);

        box = new JCheckBox();
        box.setText("I'm not a robot");
        box.setFocusable(false);
        box.setIcon(crossIcon);
        box.setSelectedIcon(checkIcon);

        this.add(button);
        this.add(box);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if( e.getSource()==button ){
            System.out.println(box.isSelected());
        }
    }
}
