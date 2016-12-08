package Lee.com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawPane extends JPanel {
	private Timer timer;
/*	private int xpos = 0;
	private int delta = 10;
	public DrawPane(){
	timer = new Timer(100,
			new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					xpos += delta;
					if(xpos >= getWidth() - 50){
						xpos = getWidth() - 50;
						delta = -delta;
					}
					if(xpos <= 0){
						xpos = 0;
						delta = -delta;
					}
					repaint();
				}	
	});
	timer.start();
	}
	@Override
	protected void paintComponent(Graphics g){
		// TODO Auto-generated method stub
	super.paintComponent(g);
	g.fillOval(xpos, 100, 50, 50);
} */
	private int ypos = 0;
	private double t = 0;
	private double delta = 0.2;
	public DrawPane(){
		timer = new Timer(50,
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e){
						// TODO Auto-generated method stub
						t += delta;
						ypos = (int)(5 * t * t);
						repaint();
					}
		});
		timer.start();
	}
	@Override
	protected void paintComponent(Graphics g){
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.fillOval(100, ypos, 50, 50);
	}
	
	
/*	g.setColor(Color.blue);
	int w = this.getWidth() / 8;
	int h = this.getHeight() / 12;
	for(int row = 0;row < 13;row++){
		g.drawLine(0, row * h, this.getWidth(), row * h);
	}
	for(int col = 0;col < 9; col++){
		g.drawLine(col * w, 0, col * w, this.getHeight());
	}
	g.setColor(Color.magenta);
	g.fillOval(50, 50, 200, 200);   */
	
	
	/*g.setColor(Color.red);
	for(int i = 0; i < 6;i++){
		g.fillRect(50 + i*50, 50 + i*50, 1000 - i*2*50, 600 - i*2*50);
	}
	g.setColor(Color.blue);
	for(int i = 0; i < 6;i++){
		g.drawLine(50 + i*50, 50 + i*50, 1000 - i*2*50, 600 - i*2*50);
	}
	for(int i = 0; i < 6;i++){
		g.drawRoundRect(50 + i*50, 50 + i*50, 1000 - i*2*50, 600 - i*2*50, 90, 90);
	}	
}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrawPane drawPane = new DrawPane();
		JButton button = new JButton("");
		JFrame f = new JFrame();
		f.getContentPane().add(drawPane);
		Graphics g = drawPane.getGraphics();
		f.setSize(400,300);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

}
