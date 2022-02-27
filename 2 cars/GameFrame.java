import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

	GameFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());

		this.add(new GamePanel());

		this.pack();
		this.setVisible(true);
	}
}