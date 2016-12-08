package wang.com.view;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

class ClockPane extends JPanel {

	private Clock clock;
	public ClockPane(){
		clock = new Clock(this);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(1.5f));
		clock.draw(g2);
	}
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(40,40);
	}
	@Override
	public Dimension getMaximumSize() {
		// TODO Auto-generated method stub
		return getPreferredSize();
	}
	@Override
	public Dimension getMinimumSize() {
		// TODO Auto-generated method stub
		return getPreferredSize();
	}
	
	public void move(){
		clock.move();
	}
	public void reset(){
		clock.reset();
	}
}
