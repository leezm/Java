package wang.com.view;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

class Clock {
	private double minuteLength = 12;
	private double secondLength = 15;
	private double minuteAlpha = -Math.PI / 2;
	private double secondAlpha = -Math.PI / 2;
	
	private Ellipse2D circle = new Ellipse2D.Double();
	private Line2D minuteLine = new Line2D.Double();
	private Line2D secondLine = new Line2D.Double();
	
	private JPanel view;
	
	public Clock(JPanel view){
		this.view = view;
		circle.setFrameFromCenter(0, 0, -18, -18);
		minuteLine.setLine(0, 0, minuteLength * Math.cos(minuteAlpha), minuteLength * Math.sin(minuteAlpha));
		secondLine.setLine(0, 0, secondLength * Math.cos(secondAlpha), secondLength * Math.sin(secondAlpha));
	}
	
	public void draw(Graphics2D g){
		g.translate((double)view.getWidth() / 2, (double)view.getHeight() / 2);
		g.draw(circle);
		g.draw(minuteLine);
		g.draw(secondLine);
	}
	
	public void move(){
		minuteAlpha += Math.PI / 1800;
		secondAlpha += Math.PI / 30;
		minuteLine.setLine(0, 0, minuteLength * Math.cos(minuteAlpha), minuteLength * Math.sin(minuteAlpha));
		secondLine.setLine(0, 0, secondLength * Math.cos(secondAlpha), secondLength * Math.sin(secondAlpha));
		view.repaint();
	}
	
	public void reset(){
		minuteAlpha = -Math.PI / 2;
		secondAlpha = -Math.PI / 2;
		minuteLine.setLine(0, 0, minuteLength * Math.cos(minuteAlpha), minuteLength * Math.sin(minuteAlpha));
		secondLine.setLine(0, 0, secondLength * Math.cos(secondAlpha), secondLength * Math.sin(secondAlpha));
		view.repaint();
	}
}
