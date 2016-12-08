package Lee.com.control;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Lee.com.model.MoveCircle;
import Lee.com.view.MoveCircleView;

public class MoveCircleController {
	private MoveCircle circle;
	private MoveCircleView view;
	private JSlider radiusSlider;
	private JTextField radiusField;
	private JSlider angularVelocitySlider;
	private JTextField angularVelocityField;
	
	private Timer timer;
	public MoveCircleController(){
		timer = new Timer(50, 
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					circle.move();
				}
			
		});
		timer.start();
	}
	
	
	public void setMoveCircleView(MoveCircleView v, MoveCircle c){
		this.view = v;
		this.circle = c;
		view.setMoveCircle(circle);
	}
	
	public JPanel getControllerView(){
		JPanel south = new JPanel(new GridLayout(2, 1, 1, 1));
		
		radiusSlider = new JSlider(30, 290, (int)circle.getLargeRadius());
		radiusField = new JTextField(String.valueOf(radiusSlider.getValue()), 8);

		radiusSlider.addChangeListener(
			new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					int value = radiusSlider.getValue();
					radiusField.setText(String.valueOf(value));
					circle.setLargeRadius(value);
				}
				
			});
		radiusField.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int value = Integer.parseInt(radiusField.getText());
					radiusSlider.setValue(value);
					value = radiusSlider.getValue();
					radiusField.setText(String.valueOf(value));
					circle.setLargeRadius(value);
				}
				
			});
		
		JPanel radiusPane = new JPanel();
		Box radiusBox = Box.createHorizontalBox();
		radiusBox.add(new JLabel("°ë¾¶"));
		radiusBox.add(Box.createHorizontalStrut(5));
		radiusBox.add(radiusSlider);
		radiusBox.add(Box.createHorizontalStrut(5));
		radiusBox.add(radiusField);
		
		radiusPane.add(radiusBox);
		
		angularVelocitySlider = new JSlider(0, 100, (int)(circle.getDelta() * 200));
		angularVelocityField = new JTextField(String.valueOf((double)angularVelocitySlider.getValue() / 200), 8);
		
		angularVelocitySlider.addChangeListener(
				new ChangeListener(){

					@Override
					public void stateChanged(ChangeEvent e) {
						// TODO Auto-generated method stub
						int value = angularVelocitySlider.getValue();
						angularVelocityField.setText(String.valueOf((double)angularVelocitySlider.getValue() / 200));
						circle.setDelta((double)value / 200);
					}
					
				});
			angularVelocityField.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						double value = Double.parseDouble(angularVelocityField.getText());
						angularVelocitySlider.setValue((int)(value * 200));
						value = angularVelocitySlider.getValue();
						angularVelocityField.setText(String.valueOf(value / 200));
						circle.setDelta(value / 200);
					}
					
				});
		
		JPanel angularVelocityPane = new JPanel();
		Box angularVelocityBox = Box.createHorizontalBox();
		angularVelocityBox.add(new JLabel("×ªËÙ"));
		angularVelocityBox.add(Box.createHorizontalStrut(5));
		angularVelocityBox.add(angularVelocitySlider);
		angularVelocityBox.add(Box.createHorizontalStrut(5));
		angularVelocityBox.add(angularVelocityField);
		
		angularVelocityPane.add(angularVelocityBox);
		
		south.add(radiusPane);
		south.add(angularVelocityPane);
		return south;
	}
}
