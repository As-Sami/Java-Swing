import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame implements ActionListener{

    JMenuItem load_i, save_i, exit_i;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());   

        JMenuBar menuBar = new JMenuBar();
        
        JMenu file_m = new JMenu("File");
        JMenu edit_m = new JMenu("Edit");
        JMenu help_m = new JMenu("Help");

        load_i = new JMenuItem("Load");
        save_i = new JMenuItem("Save");
        exit_i = new JMenuItem("Exit");

        load_i.addActionListener(this);
        save_i.addActionListener(this);
        exit_i.addActionListener(this);

        // key board stroke... we can use these in menu
        load_i.setMnemonic(KeyEvent.VK_L); // l for load
        save_i.setMnemonic(KeyEvent.VK_S); // s for save
        exit_i.setMnemonic(KeyEvent.VK_E); // e for exit

        file_m.add(load_i);
        file_m.add(save_i);
        file_m.add(exit_i);

        menuBar.add(file_m);
        menuBar.add(edit_m);
        menuBar.add(help_m);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if( e.getSource()==load_i ){
            System.out.println("Page loaded");
        }else if( e.getSource()==save_i ){
            System.out.println("Saved");
        }else if( e.getSource()==exit_i ){
            System.out.println("Page exited");
            System.exit(0);
        }
    }
}
