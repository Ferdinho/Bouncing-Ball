import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class BoardGamePanel extends JPanel implements Runnable{

	List<Ball> balls;

	public BoardGamePanel() {
		balls = new ArrayList<Ball>();
	}

	void addBall(int x, int y){
		Random rand = new Random ();
		final float h = rand.nextFloat();
		final float s = 0.9f;
		final float l = 1.0f; 
		Ball bounce = new Ball(x, y, 40, Color.getHSBColor(h, s, l));
		balls.add(bounce);
		Thread t= new Thread(bounce);
		t.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Ball b : balls) {
			b.draw(g);
		}
		this.repaint();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException ex) {
			}
			this.repaint();
		}
	}
}
