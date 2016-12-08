package wang.com.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

class TipPane extends JPanel {

	private ClockPane clockPane;
	private StringTipPane stringTipPane;
	
	public TipPane(){
		setLayout(new BorderLayout());
		clockPane = new ClockPane();
		stringTipPane = new StringTipPane("耐心，细心");
		add(clockPane, BorderLayout.WEST);
		add(stringTipPane, BorderLayout.CENTER);
	}
	
	public void move(){
		clockPane.move();
	}
	
	public void setText(String tip){
		stringTipPane.setText(tip);
	}
	
	public void reset(){
		clockPane.reset();
		stringTipPane.setText("耐心，细心");
	}
}
