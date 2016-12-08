package Lee.com;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPane extends JPanel {
	private double largeRadius = 265;
	private double radius = 15;
	private double alpha = -Math.PI / 2;
	private double delta = 0.2;
	
	private Timer timer;
	public DrawPane(){
		this.addMouseListener(
				new MouseAdapter(){
					public void mousePressed(MouseEvent e){
						timer.start();
					}
			
		});
		timer = new Timer(50,
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						alpha += delta;
						repaint();
					}
		
		});
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		int cx = this.getWidth() / 2;
		int cy = this.getHeight() / 2;
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setStroke(new BasicStroke(2.0f));
		g2.fill(new Ellipse2D.Double(cx + largeRadius * Math.cos(alpha) - radius,cy + largeRadius * Math.sin(alpha) - radius,2*radius,2*radius));
		g2.draw(new Ellipse2D.Double(cx - largeRadius,cy - largeRadius,2 * largeRadius,2 * largeRadius));
		g2.draw(new Line2D.Double(cx,cy,cx + largeRadius * Math.cos(alpha),cy + largeRadius * Math.sin(alpha)));
	}
/*	public static void main(String[] args){
		JFrame f = new JFrame();
		DrawPane drawPane = new DrawPane();
		f.getContentPane().add(drawPane);
		f.setSize(800,600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	*/

}
