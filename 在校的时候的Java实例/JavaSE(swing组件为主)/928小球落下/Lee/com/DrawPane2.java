package Lee.com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;


public class DrawPane2 extends JFrame {
	private int x;
	private int y;
	boolean isPoint = false;
	
	public DrawPane2(String title){
		super();
		addMouseListener(
				new MouseAdapter(){

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						super.mouseClicked(e);
						if(e.getButton() == MouseEvent.BUTTON1){
							x = e.getX();
							y = e.getY();
							isPoint = true;
							repaint();
						}else if(e.getButton() == MouseEvent.BUTTON3){
							isPoint = false;
							repaint();
						}
					}
					
					
				}
				);
		this.setSize(400,300);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	


	public void paint(Graphics g) {
		
		 for(int i = 0; i < 13; i++){
				g.setColor(Color.red);
				g.drawLine(0,this.getHeight()/12 * i,  this.getWidth(), this.getHeight()/12 * i);
			}
			for(int j = 0; j < 9; j++){
				g.setColor(Color.lightGray);
				g.drawLine(this.getWidth()/8 * j,0,this.getWidth()/8 * j,this.getHeight());
			}
		if(isPoint){
			g.setColor(Color.blue);
			g.fillOval(x, y, 20, 20);
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		new DrawPane2("µã»÷³öÀ´Ô²");	
	}

}

