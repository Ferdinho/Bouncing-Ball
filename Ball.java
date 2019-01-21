import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class Ball extends JPanel implements Runnable {


	private int x = 0;
	public int x_coord = 0;
	public int y_coord = 0;
	private int y = 0;
	private int diameter = 0 ;
	private Color color;

	int width = 600;
	int height= 600;
	int radius = 20;
	int dx=0, dy =0;

	public Ball(int x, int y, int diameter, Color color) {
		super();
		this.x = x;
		this.y = y;
		x_coord= x;
		y_coord = y;
		this.diameter = diameter;
		this.color = color;
		Random rand = new Random ();
		dx = rand.nextInt(20)-15;
		dy= rand.nextInt(20)-15;

	}




	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public int getDiameter() {
		return diameter;
	}


	public Color getColor() {
		return color;
	}

	public void draw (Graphics g) {
		g.setColor(color);
		g.fillOval(x_coord, y_coord, diameter, diameter);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	// This method changes the speed in Y axis 
	public void changeXVelocity() {

		Random rand = new Random ();
		int newXSpeed = rand.nextInt(10)+8; 
		if(dx>0) {
			dx= 0 - newXSpeed;
			if(x_coord - dx >= width) {
				x_coord = width-diameter;
			}

		}else {
			dx=newXSpeed;
			if(x_coord + dx <= 0) {
				x_coord = 0;
			}
		}
	}

	// This method changes the speed in Y axis 
	public void changeYVelocity() {

		Random rand = new Random ();
		int newYSpeed = rand.nextInt(10)+8; 
		if(dy>0) {
			dy= 0 - newYSpeed;
			if(y_coord - dy > height) {
				y_coord = height-diameter;
			}
		}else {
			dy=newYSpeed;
			if(y_coord + dy < 0) {
				y_coord = 0;
			}
		}
	}


	public void run() {
		while (true) { 
			x_coord = x_coord + dx ;
			y_coord = y_coord + dy;

			if ((x_coord  <= 0)|| (x_coord + diameter + radius >= width)) {
				changeXVelocity();

			}
			if ((y_coord <= 0)||(y_coord + diameter*2 >= height)) {
				changeYVelocity();

			}
			try {
				Thread.sleep(100); 
			} catch (InterruptedException ex) {
			}
			this.repaint();
		}

	}
}
