package wang.com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

import wang.com.model.Wheel;

public class MainFrame extends JFrame {

	private boolean isRun = false;
	private Timer timer;
	public MainFrame(){
		WheelView view = new WheelView();
		this.getContentPane().add(view);
		
		setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		final Wheel wheel = new Wheel(view);
		view.setWheel(wheel);
		
		timer = new Timer(50,
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					wheel.move();
				}
			
		});
		
		view.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					if(!isRun){
						timer.start();
					}else{
						timer.stop();
					}
					isRun = !isRun;
				}
			});
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
