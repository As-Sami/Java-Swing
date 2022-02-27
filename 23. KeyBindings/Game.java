import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;

public class Game {
    JFrame frame;
    JLabel label;
    Action upAction, downAction, rightAction, leftAction;
    Game(){

        frame = new JFrame("Key Binding");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);

        label = new JLabel();
        label.setBackground(Color.red);
        label.setBounds(100, 100, 100, 100);
        label.setOpaque(true);

        upAction = new UpAction();
        downAction = new DownAction();
        rightAction = new RightAction();
        leftAction = new LeftAction();

        label.getInputMap().put(KeyStroke.getKeyStroke("UP"), "u");
        label.getActionMap().put("u", upAction);
        label.getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "d");
        label.getActionMap().put("d", downAction);
        label.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "l");
        label.getActionMap().put("l", leftAction);
        label.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "r");
        label.getActionMap().put("r", rightAction);
        

        frame.add(label);
        frame.setVisible(true);
    }

    private class UpAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e){
            label.setLocation( label.getX() , label.getY()-10 );
        }
    }

    private class DownAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e){
            label.setLocation( label.getX() , label.getY()+10 );
        }
    }

    private class LeftAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e){
            label.setLocation( label.getX()-10 , label.getY() );
        }
    }

    private class RightAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e){
            label.setLocation( label.getX()+10 , label.getY() );
        }
    }

    
}

