package Lee.com;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawPanel extends JPanel {
	private Timer timer ;
	//（横向 ）动点+反弹
	public int xpos = 0;
	public int dir = 5;
	
	//自由落体
	private int ypos = 0;
	private double t = 0;
	private double director = 0.2;
//	public int Hh = getHeight()-60;
	
	public DrawPanel(){
		
		//（横向）  动点+反弹  监听器
/*		timer = new Timer(10,
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						xpos += dir;
						if(xpos >= getWidth()-50){
							xpos = getWidth()-50;
							dir = -dir;
						}
						if(xpos <= 0){
							xpos = 0;
							dir = -dir;
						}
						repaint();
					}
					
		});
		timer.start();
}*/
		
		
		//自由落体监听器
	/*	timer = new Timer(50,
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						t += director;
						ypos = (int)(5*t*t);
						repaint();
					}
			
		});
		timer.start();
		*/
		
		
		//自由落体动能守恒
		timer = new Timer(60,
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					//	t += director;
						if(ypos > getHeight()-60){
							ypos = getHeight()-60;
							ypos =(int)((getHeight()-60-(int)Math.sqrt(20*(getHeight()-60))*t + 5*t*t));
							ypos = 0;
							director = -director;
						//	System.out.print(getHeight());
							
						}
						if(ypos <= getHeight()-60){
							t += director;
							ypos = 50;
							ypos = (int)(5*t*t + 50);
					//		System.out.print(getHeight());
						}
						repaint();
					}
			
		});
		timer.start();
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		//*****画表格*****//
	/*	int w = this.getWidth() / 12;
		int h = this.getHeight() / 8;
		
		for(int row = 0;row < 9;row++){
			g.setColor(Color.blue);
			g.drawLine(0, row * h, this.getWidth(), row * h);
		}
		for(int col = 0;col < 13;col++){
			g.setColor(Color.blue);
			g.drawLine(col * w, 0, col * w, this.getHeight());
		}*/

		
		
		//*****画跑道*****//
	/*	int x = 10,y = 10,w = 1300,h = 800;
		int arcW = 800,arcH = 800;
		g.setColor(new Color(255,120,150));
		for(int i = 0;i < 10;i++){
			g.drawRoundRect(x+i*30, y+i*30, w-2*i*30, h-2*i*30, arcW-2*i*30, arcH-2*i*30);
		}*/
		
		
		//*****画动点*****//
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		
	//	g.setColor(new Color(red,green,blue));
	//	g.fillOval(xpos, 200, 50, 50);
		
		//(自由落体)
		g.drawLine(100, 49, 500, 49);
		g.drawLine(100, 50, 500, 50);
		
		g.fillOval(250, ypos, 60, 60);
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DrawPanel drawpaint = new DrawPanel();
		
		JFrame f= new JFrame();
		f.getContentPane().add(drawpaint);
		f.setSize(600,700);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO Auto-generated method stub

	}

}
