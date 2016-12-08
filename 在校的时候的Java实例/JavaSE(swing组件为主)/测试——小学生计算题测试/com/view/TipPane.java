package wang.com.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

class TipPane extends JPanel {

	private ClockPane clockPane;
	private StringTipPane stringTipPane;
	
	public TipPane(){
		setLayout(new BorderLayout());
		clockPane = new ClockPane();
		stringTipPane = new StringTipPane("���ģ�ϸ��");
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
		stringTipPane.setText("���ģ�ϸ��");
	}
}
