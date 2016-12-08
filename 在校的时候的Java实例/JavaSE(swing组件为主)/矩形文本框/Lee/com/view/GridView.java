package Lee.com.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import Lee.com.domain.Grid;

public class GridView extends JPanel {
	private Grid grid;

	public void setGrid(Grid grid){
		this.grid = grid;
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(grid != null){
			grid.drawGrid(g);
		}
	}
}
