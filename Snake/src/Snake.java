import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Snake {
	
	private Node head = null;
	private Node tail = null;
	int size=0;
	private Node n = new Node(20,30,Dir.L);
	private Yard y;
	
	private class Node{
		
		int w=Yard.BLOCK_SIZE;
		int h=Yard.BLOCK_SIZE;
		int row, col;
		Dir dir = Dir.L;
		Node next=null;
		Node pre = null;
			
		Node(int row, int col, Dir dir){
			this.row=row;
			this.col=col;
			this.dir=dir;
		}
		
		void draw(Graphics g) {
			Color c=g.getColor();
			g.setColor(Color.BLACK);
			g.fillRect(Yard.BLOCK_SIZE*row,Yard.BLOCK_SIZE*col, w, h);
				
			g.setColor(c);
		}

	}
	
	
	
	public Snake(Node node) { 
		head =node;
		tail = node;
		size =1;
	}
	 
	
	public void addToHead() {
		Node node=null;
		
		switch(head.dir) {
		case L:
			node = new Node(head.row, head.col+1,head.dir);
			break;
		case R:
			node = new Node(head.row,head.col-1,head.dir);
			break;
		case U:
			node = new Node(head.row,head.col+1,head.dir);
			break;
		case D:
			node = new Node(head.row,head.col-1,head.dir);
			break;
		}
		node.next=head;
		head=node;
		node.pre=tail;
		size++;
		
	}
	
	public void draw(Graphics g) {
		if(size<=0) return;
		for(Node n=head; n!=null;n=n.next) {
			n.draw(g);
		}
		move();

	}
	
	private void move() {
		// TODO Auto-generated method stub
		addToHead();
		deleteFromTail();
		checkDead();
	}


	private void checkDead() {
		// TODO Auto-generated method stub
		if(head.row<0 || head.col<2||head.row>Yard.ROWS||head.col<Yard.COLS) {
			y.stop();
		}
	}


	private void deleteFromTail() {
		// TODO Auto-generated method stub
		if(size==0) return;
		tail = tail.pre;
		tail.pre=null;
		
	}


	public Snake(Yard y) {
		//this(new Node(20, 40, Dir.L));
		head=n;
		tail=n;
		size=1;
		this.y = y;
		
	}


	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key=e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
			head.dir = Dir.U;
			break;
		case KeyEvent.VK_LEFT:
			head.dir = Dir.L;
			break;
		case KeyEvent.VK_RIGHT:
			head.dir = Dir.R;
			break;
		case KeyEvent.VK_DOWN:
			head.dir = Dir.D;
			break;

			
		}
	}
	
 
	public void eat(Egg e) {
		if(this.getRect().intersects(e.getRect())) {
			e.reAppear();
			this.addToHead();
			y.setScore(y.getScore()+5);
		}
	}
	
	private Rectangle getRect() {
		return new Rectangle();
	}
	
	
	


}
