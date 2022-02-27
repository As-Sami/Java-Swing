import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{
    
    JComboBox box;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        String[] animals = {"dog", "cat", "bird"};
        box = new JComboBox(animals); // the array should be a reference type
        box.addActionListener(this);

        // box.setEditable(true);
        // box.getItemCount();
        // box.addItem( item );
        // box.insertItemAt(item, index);
        // box.setSelectedIndex( index );
        // box.removeItem( item );
        // box.removeItemAt( index );
        // box.removeAllItems();

        this.add(box);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if( e.getSource()==box ){
            System.out.println(box.getSelectedItem());
            System.out.println(box.getSelectedIndex());
        }
    }
}
