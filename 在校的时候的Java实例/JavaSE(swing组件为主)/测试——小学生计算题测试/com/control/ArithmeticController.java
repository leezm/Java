package wang.com.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.Timer;

import wang.com.view.ArithmeticView;
import wang.com.view.ButtonsPane;
import wang.com.model.Arithmetic;

public class ArithmeticController {

	private Timer timer;
	private final int MAX = 120;
	private int escape = 0;
	private ArithmeticView view;
	private JButton[] buttons;
	
	private Arithmetic arithmetic;
	private StringBuffer arithmetics = new StringBuffer();
	private int correct = 0;
	private int amount = 0;
	
	public ArithmeticController(){
		timer = new Timer(1000,
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					view.move();
					escape++;
					int count = MAX - escape;
					if(count < 60){
						String tip = "00:" + ((count < 10) ? "0" : "") + count;
						view.setText(tip);
						if(escape >= MAX){
							timer.stop();
							double score = 100 * (double)correct / amount;
							arithmetics.append("本次测试成绩为：         " + score);
							buttons[0].setEnabled(true);
							buttons[1].setEnabled(true);
							buttons[2].setEnabled(true);
							escape = 0;
							amount = 0;
							correct = 0;
							view.reset();
						}
					}
				}
			
		});
	}
	public void setArithmeticView(ArithmeticView v){
		this.view = v;
		this.view.addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int answer = view.getAnswer();
					arithmetic.setAnswer(answer);
					amount++;
					if(arithmetic.getResult() == 1){
						correct ++;
					}
					arithmetics.append(arithmetic.toString());
					
					arithmetic = Arithmetic.createArithmetic();
					view.showQuestion(arithmetic);
				}
				
			});
	}
	
	public JPanel getButtonsPane(){
		String[] titles = {"开始","显示","保存","退出"};
		ButtonsPane buttonsPane = new ButtonsPane(4);
		buttonsPane.setTitles(titles);
		
		buttons = buttonsPane.getButtons();
		buttons[1].setEnabled(false);
		buttons[2].setEnabled(false);
		
		buttons[0].addActionListener(
			new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					timer.start();
					buttons[0].setEnabled(false);
					buttons[1].setEnabled(false);
					buttons[2].setEnabled(false);
					
					view.setResult("");
					arithmetic = Arithmetic.createArithmetic();
					view.start(arithmetic);
					
					arithmetics.delete(0, arithmetics.length());
					Calendar toDay = Calendar.getInstance();
					int month = toDay.get(Calendar.MONTH) + 1;
					int day = toDay.get(Calendar.DAY_OF_MONTH);
					int hour = toDay.get(Calendar.HOUR);
					int minute = toDay.get(Calendar.MINUTE);
					int second = toDay.get(Calendar.SECOND);
					
					String datetime = toDay.get(Calendar.YEAR) + "年" + (((month < 10) ? "0" : "") + month) + "月" + (((day < 10) ? "0" : "") + day) + "日              " +
					(((hour < 10) ? "0" : "") + hour) + ":" + (((minute < 10) ? "0" : "") + minute) + ":" + (((second < 10) ? "0" : "") + second) + "\n";
					arithmetics.append(datetime);
				}
				
			});
		buttons[1].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						view.setResult(arithmetics.toString());
					}
					
				});
		buttons[2].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						save();
					}
					
				});
		buttons[3].addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
					
				});
		
		return buttonsPane;
	}
	private void save(){
		try{
			JFileChooser chooser = new JFileChooser();
			int option = chooser.showSaveDialog(view);
			if(option == JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				PrintWriter out = new PrintWriter(new FileOutputStream(file, true),true);
				out.println(arithmetics.toString());
				out.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
