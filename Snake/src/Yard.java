import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;

public class Yard extends Frame {
	
	

	private boolean flag=true;

	private int score;
	public static final int ROWS = 50;
	public static final int COLS = 50;
	public static final int BLOCK_SIZE = 50;
	
	Snake snake = new Snake(this);
	
	Image offScreenImage = null;
	Egg egg = new Egg();
	
	public void launch() {
		this.setLocation(100,100);
		this.setSize(COLS*BLOCK_SIZE, ROWS*BLOCK_SIZE);
		this.setVisible(true);
		new Thread(new PaintThread()).start();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
			

		
		});
		
	}
	

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		//super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, COLS*BLOCK_SIZE, ROWS*BLOCK_SIZE);
		g.setColor(Color.DARK_GRAY);
		
		for(int i=0;i<ROWS;i++) {
			g.drawLine(0, BLOCK_SIZE*i, COLS*BLOCK_SIZE, BLOCK_SIZE*i+ROWS);
		}
		for(int i=0;i<COLS;i++) {
			g.drawLine(BLOCK_SIZE*i, 0, BLOCK_SIZE*i+ROWS,ROWS*BLOCK_SIZE);
		}
		
		
		g.setColor(Color.YELLOW);
		g.drawString("score is" + score, 20, 20);
		
		g.setColor(c);
		
		snake.eat(egg);
		egg.draw(g);
		snake.draw(g);
		if(flag==false) {
			
		}
		
	}
	
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		//super.update(g);
		if(offScreenImage==null) {
			offScreenImage = this.createImage(COLS*BLOCK_SIZE, ROWS*BLOCK_SIZE);
		}
		Graphics gg = offScreenImage.getGraphics();
		paint(gg);
		g.drawImage(offScreenImage, 0, 0, null);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Yard().launch();

	}
	
	
	private class PaintThread implements Runnable{
		public void run() {
			while(flag) {
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	private class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			snake.keyPressed(e);
		}
		
		
	}
	
	public void stop() {
		flag=false;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}



	
	

}
