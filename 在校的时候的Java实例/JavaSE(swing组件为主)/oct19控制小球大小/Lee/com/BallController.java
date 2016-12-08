package Lee.com;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BallController {
	private Ball ball;
	private BallView view;
	
	private JTextField radiusField;
	private JSlider slider;
	
	public void setBallView(BallView v){
		this.view = v;
		ball = new Ball(view);
		view.setBall(ball);
		ball.setRadius(50);
		ball.setCenter(view.getWidth() / 2, view.getHeight() / 2);
	}
	
	public JPanel getSouth(){
		JPanel south = new JPanel();
		
		slider = new JSlider(10, 200, 100);
		radiusField = new JTextField(String.valueOf(slider.getValue()), 8);
		
		slider.addChangeListener(
			new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					int value = slider.getValue();
					ball.setRadius(value);
					radiusField.setText(String.valueOf(value));
				}
				
			});
		
		radiusField.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int value = Integer.parseInt(radiusField.getText());
					ball.setRadius(value);
					slider.setValue(value);
				}
				
			});
		
		Box box = Box.createHorizontalBox();
		box.add(new JLabel("°ë¾¶"));
		box.add(Box.createHorizontalStrut(5));
		box.add(slider);
		box.add(Box.createHorizontalStrut(5));
		box.add(radiusField);
		
		south.add(box);
		return south;
	}
}
