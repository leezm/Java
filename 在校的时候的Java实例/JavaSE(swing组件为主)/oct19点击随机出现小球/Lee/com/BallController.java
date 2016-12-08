package Lee.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

public class BallController {
	private BallView view;
	private Timer timer;
	private ArrayList<Ball>balls;
	
	public BallController(){
		timer = new Timer(50, 
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int index = 0; index < balls.size(); index++){
						balls.get(index).move();
					}
				}
			
		});
	}
	public void setBallView(BallView v){
		this.view = v;
		view.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					Ball ball = new Ball(view, e.getX(), e.getY());
					view.addBall(ball);
					timer.start();
				}
			});
		balls = view.getBalls();
	}
}
