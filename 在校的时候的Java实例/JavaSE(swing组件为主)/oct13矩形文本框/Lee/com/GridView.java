package Lee.com;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridView extends JPanel {
	private int rows = 12;
	private int cols = 8;
	private Color color = Color.black;
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		int w = this.getWidth() / cols;
		int h = this.getHeight() / rows;
		g.setColor(color);
		
		for(int row = 0; row <= rows; row++){
			g.drawLine(0, row * h, this.getWidth(), row * h);
		}
		for(int col = 0; col <= cols; col++){
			g.drawLine(col * w, 0, col * w, this.getHeight());
		}
	}
	public void setCols(int cols){
		this.cols = cols;
		repaint();
	}
	public void setRows(int rows){
		this.rows = rows;
		repaint();
	}
	public void setColor(Color color){
		this.color = color;
		repaint();
	}
	public int getRows(){
		return this.rows;
	}
	public int getCols(){
		return this.cols;
	}
}
