package zhang;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameView extends JPanel {
	private Game game = null;
	private Color color = new Color(203,233,207);
	//private Color color = new Color(236,190,120);
	private Boolean mark = false;
	private ArrayList<Game> arrays = new ArrayList<Game>();


	public void addGame(Game game) {
		this.game = game;
		
		if(mark){
			game.setColor(Color.white);
			mark = false;
		}else{
			game.setColor(Color.black);
			mark = true;
		}
		arrays.add(game);
		repaint();
	}

	public ArrayList<Game> getArrays() {
		return arrays;
	}

	public void setMark(Boolean mark) {
		this.mark = mark;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		setBackground(color);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(2.0f));
		
		if(game != null ){
			for(int index = 0; index < arrays.size(); index++){
				arrays.get(index).draw(g2);
			}
			
		}
		
	}
	
	

}
