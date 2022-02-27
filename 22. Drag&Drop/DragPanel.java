import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DragPanel extends JPanel {
    
    ImageIcon img = new ImageIcon("glass-wala.png");
    final int width = img.getIconWidth();
    final int height = img.getIconHeight();
    Point imgCorner, prevPt;
    
    DragPanel(){
        imgCorner = new Point(0,0);
        
        ClickListener cL = new ClickListener();
        DragListener dL = new DragListener();
        this.addMouseListener(cL);
        this.addMouseMotionListener(dL);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        img.paintIcon(this, g, (int)imgCorner.getX(), (int)imgCorner.getY());
    }

    private class ClickListener extends MouseAdapter{
        public void mousePressed(MouseEvent e){
            prevPt = e.getPoint();
        }
    }
    
    private class DragListener extends MouseMotionAdapter{

        public void mouseDragged(MouseEvent e){
            Point cur = e.getPoint();
            imgCorner.translate(
                        (int)(cur.getX() - prevPt.getX()) ,
                        (int)(cur.getY() - prevPt.getY())
                        );
            prevPt = cur;
            repaint();
        }
    }
}
