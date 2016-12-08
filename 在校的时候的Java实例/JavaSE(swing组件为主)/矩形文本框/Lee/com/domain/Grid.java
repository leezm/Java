package Lee.com.domain;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grid {
	private final Color[] colors = {
		Color.white, Color.red, Color.green, Color.blue, Color.cyan, Color.magenta, Color.yellow, Color.black
	};
	
	private int rowCount;
	private int columnCount;
	private int colorIndex;
	private JPanel view;
	public Grid(JPanel view) {
		this.view = view;
		// TODO Auto-generated constructor stub
	}
	public Grid(JPanel view, int rowCount, int columnCount) {
		this.view = view;
		this.rowCount = rowCount;
		this.columnCount = columnCount;
	}
	public Grid(JPanel view, int rowCount, int columnCount, int colorIndex) {
		this.view = view;
		this.rowCount = rowCount;
		this.columnCount = columnCount;
		this.colorIndex = colorIndex;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		view.repaint();
	}
	public int getColumnCount() {
		return columnCount;
	}
	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
		view.repaint();
	}
	public int getColorIndex() {
		return colorIndex;
	}
	public void setColor(int colorIndex) {
		this.colorIndex = colorIndex;
		view.repaint();
	}
	
	public void drawGrid(Graphics g){
		int width = view.getWidth();
		int height = view.getHeight();
		int cellWidth = width / columnCount;
		int cellHeight = height / rowCount;
		Color color = colors[colorIndex];
		g.setColor(color);
		for(int row = 0; row <= rowCount; row++){
			g.drawLine(0, row * cellHeight, width, row * cellHeight);
		}
		for(int col = 0; col <= columnCount; col++){
			g.drawLine(col * cellWidth, 0, col * cellWidth, height);
		}
	}
}
