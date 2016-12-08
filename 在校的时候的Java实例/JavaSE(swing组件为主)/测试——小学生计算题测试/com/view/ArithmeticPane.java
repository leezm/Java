package wang.com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import wang.com.model.Arithmetic;

class ArithmeticPane extends JPanel {
	private JLabel[] labels = new JLabel[4];
	private JTextField field;
	
	public ArithmeticPane(){
		setLayout(new GridLayout(1, 5, 1, 1));
		for(int i = 0; i < labels.length; i++){
			labels[i] = new JLabel();
			labels[i].setOpaque(true);
			labels[i].setBackground(Color.white);
			labels[i].setFont(new Font("ºÚÌå", Font.PLAIN, 16));
			labels[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(labels[i]);
		}
		field = new JTextField();
		add(field);
		field.setEnabled(false);
	}
	
	public void showQuestion(Arithmetic arithmetic){
		labels[0].setText(String.valueOf(arithmetic.getLeft()));
		labels[1].setText(Arithmetic.getOperator(arithmetic.getOperatorCode()));
		labels[2].setText(String.valueOf(arithmetic.getRight()));
		labels[3].setText("=");
		field.setText("");
		field.grabFocus();
	}
	
	public int getAnswer(){
		return Integer.parseInt(field.getText());
	}
	
	public void start(Arithmetic arithmetic){
		field.setEnabled(true);
		showQuestion(arithmetic);
	}
	public void addActionListener(ActionListener listener){
		field.addActionListener(listener);
	}
	
	public void reset(){
		for(int i = 0; i < labels.length; i++){
			labels[i].setText("");
		}
		field.setText("");
		field.setEnabled(false);
	}
}
