import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Egg {
	private static Random r = new Random();
	int h = Yard.BLOCK_SIZE;
	int row, col;
	int w = Yard.BLOCK_SIZE;

	public Egg() {
		this(r.nextInt(Yard.ROWS), r.nextInt(Yard.COLS));
	}
	
	public Egg(int row, int col) {
		//super();
		this.row = row;
		this.col = col;
	}
	
	

	public void draw(Graphics g) {
		Color c = g.getColor();	
		g.setColor(Color.GREEN);
		g.fillOval(Yard.BLOCK_SIZE*col, Yard.BLOCK_SIZE*row, w, h);
		g.setColor(c);
		
	
	}
	
	public int getCol() {
		return col;
	}

	public Rectangle getRect() {
		return new Rectangle();
	}

	public int getRow() {
		return row;
	}

	public void reAppear() {
		// TODO Auto-generated method stub
		this.row = r.nextInt(Yard.ROWS);

		
	}

	public void setCol(int col) {
		this.col = col;
	}

	public void setRow(int row) {
		this.row = row;
	}

	
	
}
