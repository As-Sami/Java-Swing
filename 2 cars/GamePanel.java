import java.util.Random;
import java.util.concurrent.TimeUnit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FontMetrics;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{

	final int S_W = 400, S_H = 600;
	final Color bg = new Color(37, 51, 122);
	final Color blue = new Color(2, 171, 194);
	final Color red = new Color(244, 58, 95);

	char redPos = 'L', bluePos = 'R';

	int redX,  blueX;

	Obstacle obs[] = new Obstacle[10];
	boolean running = false;

	Random random = new Random();
	Timer timer;
	int timr, score;

	GamePanel(){
		
		this.setPreferredSize(new Dimension( S_W, S_H ) );
		this.setBackground( bg );
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());

		for( int i=0 ; i<10 ; i++ )
			obs[i] = new Obstacle(50, Color.BLACK, true, true);

		redX = 50;
		blueX = 350;
		score = 0;

		start();
	}

	public void start(){
		running = true;

		timr = 0;
		timer = new Timer(30, this);
		timer.start();
	}

	public void newObs(){

		
		for( int i=0 ; i<10 ; i++ ){
			if( obs[i].c==Color.BLACK && random.nextBoolean() ){
				obs[i] = new Obstacle( -20, red, 
					random.nextBoolean(), random.nextBoolean());
				break;
			}
		}


		for( int i=0 ; i<10 ; i++ ){
			if( obs[i].c==Color.BLACK && random.nextBoolean() ){
				obs[i] = new Obstacle( -20, blue, 
					random.nextBoolean(), random.nextBoolean());
				break;
			}
		}
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g){

		if ( running ){

			// drawing middle lane
			g.setColor(Color.white);
			g.fillRect( S_W/2 - 2 , 0, 4, S_H);
			
			// sub lanes
			g.setColor(Color.gray);
			g.fillRect( S_W/4 - 1 , 0, 2, S_H);
			g.fillRect( S_W/4*3 - 1 , 0, 2, S_H);
			
			// car
			drawCar(g, red , redX); // red  car
			drawCar(g, blue, blueX); // blue car
			// x, y, width, height, arcWidth, arcHeight
			
			for( int i=0 ; i<10 ; i++ ){
				if( obs[i].c==Color.BLACK ) continue;
				else obs[i].draw(g);;
			}
			
			g.setColor(Color.gray);
			g.setFont(new Font("Ink Free", Font.BOLD, 30));
			
			FontMetrics m = getFontMetrics(g.getFont());
			g.drawString("Score : "+score, S_W/2-m.stringWidth("Score : "+score)/2, g.getFont().getSize());
		}
		else{
			try {
				TimeUnit.SECONDS.sleep(3);
			}
			catch (Exception e) {
				System.out.println("Oops! Something went wrong!");
			}

			this.setBackground(Color.black);
			g.setColor(Color.red);
			g.setFont(new Font("Ink Free", Font.BOLD, 50));
			FontMetrics m = getFontMetrics(g.getFont());
			g.drawString("Score : "+score, S_W/2-m.stringWidth("Score : "+score)/2, S_H/2);
		}
	}

	public void drawCar(Graphics g, Color c, int x){
		g.setColor(c);
		g.fillRoundRect( x-25  , S_H-120, 50, 100, 25, 25);
		
		g.setColor(Color.white);
		g.fillRoundRect( x-20  , S_H-115, 40, 90, 25, 25);

		g.setColor(c);
		g.fillRect( x-10, S_H-85, 20, 30);
	}


	public void gameLoop(){
		timr++;

		if(timr == 40){
			newObs();
			timr = 0;
		}

		for( int i=0 ; i<10 ; i++ ){
			if( obs[i]!=null )
				obs[i].y += 5;
		}

		if( redPos=='L' && redX>50 )
			redX -= 10;
		else if( redPos=='R' && redX<150 )
			redX += 10;

		if( bluePos=='L' && blueX>250 )
			blueX -= 10;
		else if( bluePos=='R' && blueX<350 )
			blueX += 10;

	}

	public void check(){

		for( int i=0 ; i<10 ; i++ ){
			if( obs[i].c!=Color.BLACK ){
				if( obs[i].y==S_H-40 && obs[i].sq==false ){
					gameOver();
					break;
				}
				else if( obs[i].y==S_H )
					obs[i].c = Color.black;
			}

			if( obs[i].y> S_H-158 && obs[i].y<S_H-22){
				if( obs[i].c==red ){

					if( obs[i].L ){
						if (redX  - 50 <= 40){
							if(obs[i].sq){
								gameOver();
							}else{
								score++;
								obs[i].c = Color.black;
							}
						}
					}else{
						if ( 150-redX <= 40 ){
							if(obs[i].sq){
								gameOver();
							}else{
								score++;
								obs[i].c = Color.black;
							}
						}
					}
				}else if( obs[i].c==blue ){

					if( obs[i].L ){
						if (blueX - 250 <= 40){
							if(obs[i].sq){
								gameOver();
							}else{
								score++;
								obs[i].c = Color.black;
							}
						}
					}else{
						if (350-blueX <= 40){
							if(obs[i].sq){
								gameOver();
							}else{
								score++;
								obs[i].c = Color.black;
							}
						}
					}

				}
			}
		}
	}

	void gameOver(){
		running = false;
		timer.stop();
	}

	class Obstacle{
		int y;
		Color c;
		boolean sq, L;
		Obstacle(int _y, Color _c, boolean _sq, boolean _L){
			this.y = _y;
			this.c = _c;
			this.sq = _sq;
			this.L = _L;
		}

		public void draw(Graphics g){
			
			g.setColor(this.c);
			int x = 0, y = this.y;
			if(this.L)
				x = (this.c==red ? 50 : 250)-20;
			else
				x = (this.c==red ? 150 : 350)-20;

			if(this.sq){ 
				g.fillRoundRect(x,y, 40,40, 20, 20);
				
				g.setColor(Color.white);
				g.fillRoundRect(x+4,y+4, 32,32, 20, 20);

				g.setColor(c);
				g.fillRoundRect(x+8,y+8, 24,24, 20, 20);
			}
			else{ 
				g.fillOval(x, y, 40, 40);
				
				g.setColor(Color.white);
				g.fillOval(x+5, y+5, 30, 30);

				g.setColor(c);
				g.fillOval(x+10, y+10, 20, 20);
			}
			
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e){
		if(running){
			gameLoop();
			check();
		}
		repaint();
	}
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			
			switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(redPos=='L') 
						redPos = 'R';
					else 
						redPos = 'L';
					break;

				case KeyEvent.VK_RIGHT:
					if(bluePos=='L') 
						bluePos = 'R';
					else 
						bluePos = 'L';
					break;

			}
		}
	}
}