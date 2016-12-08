package wang.com.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import wang.com.model.Arithmetic;

public class NorthPane extends JPanel {

	private TipPane tipPane;
	private ArithmeticPane arithmeticPane;
	
	public NorthPane(){
		setLayout(new GridLayout(2,1,1,1));
		tipPane = new TipPane();
		arithmeticPane = new ArithmeticPane();
		add(tipPane);
		add(arithmeticPane);
		
		Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
		this.setBorder(border);
	}
	
	public void setText(String tip){
		tipPane.setText(tip);
	}
	public void move(){
		tipPane.move();
	}
	public void reset(){
		tipPane.reset();
		arithmeticPane.reset();
	}
	
	public void showQuestion(Arithmetic arithmetic){
		arithmeticPane.showQuestion(arithmetic);
	}
	public int getAnswer(){
		return arithmeticPane.getAnswer();
	}
	public void start(Arithmetic arithmetic){
		arithmeticPane.start(arithmetic);
	}
	public void addActionListener(ActionListener listener){
		arithmeticPane.addActionListener(listener);
	}
}
