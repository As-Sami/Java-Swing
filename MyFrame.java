
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MyFrame extends JFrame implements ActionListener {
		
		JLabel label;
		JButton button;
		
		MyFrame(){
			
			ImageIcon icon2=new ImageIcon("wow.png");
			ImageIcon icon=new ImageIcon("hand.jpg");
			
			
			label = new JLabel();
			label.setIcon(icon2);
			label.setBounds(150,250,150,150);
			label.setVisible(false);
			
			button=new JButton();
			button.setBounds(100,100,250,100);
			button.setText("click");
			button.setFocusable(false);
			button.setIcon(icon);
            button.setHorizontalTextPosition(JButton.CENTER);
            button.setVerticalTextPosition(JButton.BOTTOM);
            button.setFont(new Font("Comic sans",Font.BOLD,25));
            button.setIconTextGap(-5);
            button.setForeground(Color.cyan);
            button.setBackground(Color.green);
            button.setBorder(BorderFactory.createEtchedBorder());
            // button.setEnabled(true);
			
            button.addActionListener(this);  //print poo when button clicked
			
			this.setTitle("Mahmud's new game"); 
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			this.setLayout(null);
			this.setResizable(false); 
			
			
			this.add(button);
			this.add(label);
			
			this.setSize(500,500);  //sets x & y dimension
			this.setVisible(true);  //make the this visible
		
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==button) {
				label.setVisible(true);
			}
		}
}