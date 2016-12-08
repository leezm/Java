package wang.com.view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import wang.com.model.Arithmetic;

public class ArithmeticView extends JPanel {

	private NorthPane northPane;
	private JTextArea textArea;
	
	public ArithmeticView(){
		setLayout(new BorderLayout());
		northPane = new NorthPane();
		textArea = new JTextArea();
		textArea.setEditable(false);
		add(northPane, BorderLayout.NORTH);
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void setText(String tip){
		northPane.setText(tip);
	}
	public void move(){
		northPane.move();
	}
	public void reset(){
		northPane.reset();
	}
	
	public void showQuestion(Arithmetic arithmetic){
		northPane.showQuestion(arithmetic);
	}
	public int getAnswer(){
		return northPane.getAnswer();
	}
	public void start(Arithmetic arithmetic){
		northPane.start(arithmetic);
	}
	public void addActionListener(ActionListener listener){
		northPane.addActionListener(listener);
	}
	
	public void setResult(String result){
		textArea.setText(result);
	}
}
