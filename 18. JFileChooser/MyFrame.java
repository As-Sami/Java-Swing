import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{
    JButton button;

    MyFrame(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        button = new JButton("Select File");
        button.addActionListener(this);
        
        this.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if( e.getSource()==button ){
            JFileChooser chooser = new JFileChooser();

            chooser.setCurrentDirectory(new File("D:\\"));

            int resp = chooser.showOpenDialog(null); // returns 0 if u chose a file, else 1
            // chooser.showOpenDialog(null); saves a file...try this on ur own

            if( resp==JFileChooser.APPROVE_OPTION ){
                File file = new File(chooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
    }
}
