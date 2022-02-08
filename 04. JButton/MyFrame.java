import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;

public class MyFrame extends JFrame implements ActionListener{
    
    JButton button;

    MyFrame(){

        ImageIcon icon = new ImageIcon("gandu.png");

        button = new JButton();
        button.setBounds(150,100,200,150); // x,y,width,height
        button.setText("Shishir is ");
        button.setFocusable(false);
        button.setIcon(icon);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        button.setIconTextGap(10);
        button.setForeground(new Color(0x121442));  // text color
        button.setBackground(Color.LIGHT_GRAY);    // background color
        button.setBorder(BorderFactory.createEtchedBorder());
        // button.setEnabled(false); to disable the button

        button.addActionListener(this);  // this thing is needed... otherwise trigering the button nothing wont happen
        
        // button.addActionListener(e -> System.out.println("yoo boys"));  
        // you can use this by removing the "implements ActionListener" and the
        // actionPerformed function... this is called lamda expression


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if( e.getSource() == button){
            System.out.println("Gandu");
        }
    }
}
