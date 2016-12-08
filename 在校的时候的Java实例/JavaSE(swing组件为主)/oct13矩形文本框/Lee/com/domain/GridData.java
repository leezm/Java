package Lee.com.domain;

import java.awt.Color;

public class GridData {
	private int rows;
	private int cols;
	private Color color = Color.black;
	
	
	public GridData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GridData(int rows, int cols, Color color) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.color = color;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
