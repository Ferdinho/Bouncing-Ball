import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard extends JFrame implements MouseListener {

	// This is the panel 
	JFrame window;
	BoardGamePanel panel;
	public GameBoard() {
		this.window = new JFrame("Bouncing Ball Game");
		panel =new BoardGamePanel();
		Thread t = new Thread(panel);
		t.start();
		window.addMouseListener(this);
		addMouseListener(this);
		this.panel.setBackground(Color.black);
		this.window.add(panel);
		window.setSize(600, 600);
		window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		window.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// Add a ball in the position where we click 
		panel.addBall(e.getX()-35,  e.getY()-35);
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}



}
