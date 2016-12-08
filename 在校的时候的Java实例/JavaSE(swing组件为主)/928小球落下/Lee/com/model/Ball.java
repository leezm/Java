package Lee.com.model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball {
	private int xpos;
	private int ypos;
	private int deltax;
	private int deltay;
	private final int diameter = 30;
	
	private Color color = Color.black;
	private JPanel view;
	
	public Ball(int x, int y, JPanel v){
		this.view = v;
		this.xpos = x;
		this.ypos = y;
		deltax = (int)(Math.random() * 50);
		deltay = (int)(Math.random() * 50);
		int sgnx = (int)(Math.random() * 2);
		int sgny = (int)(Math.random() * 2);
		if(sgnx == 0){
			deltax = -deltax;
		}
		if(sgny == 0){
			deltay = -deltay;
		}
	}
	public void setColor(Color color){
		this.color = color;
	}
	public void drawBall(Graphics g){
		g.setColor(color);
		g.fillOval(xpos, ypos, diameter, diameter);
	}
	public void move(){
		xpos += deltax;
		ypos += deltay;
		if(xpos <= 0){
			xpos = 0;
			deltax = -deltax;
		}
		if(ypos <= 0){
			ypos = 0;
			deltay = -deltay;
		}
		if(xpos >= view.getWidth() - diameter){
			xpos = view.getWidth() - diameter;
			deltax = -deltax;
		}
		if(ypos >= view.getHeight() - diameter){
			ypos = view.getHeight() - diameter;
			deltay = -deltay;
		}
		view.repaint();
	}
}
