package Lee.com.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Lee.com.domain.Grid;

public class MainFrame extends JFrame {
	private GridView view;
	private Grid grid;
	private GridDataDialog dialog = null;
	
	public MainFrame(){
		super("模式对话框演示");
		JButton openButton = new JButton("打开");
		JButton exitButton = new JButton("退出");
		
		view = new GridView();
		grid = new Grid(view,12,8,1);
		view.setGrid(grid);
		
		JPanel southPane = new JPanel();
		southPane.add(openButton);
		southPane.add(exitButton);
		
		Container c = this.getContentPane();
		c.add(view, BorderLayout.CENTER);
		c.add(southPane, BorderLayout.SOUTH);
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		openButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(dialog == null){
							dialog = new GridDataDialog(MainFrame.this, "网格选项");
						}
						dialog.showDialog();
					}
					
				});
		exitButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
					
				});
		
	}
	public Grid getGrid(){
		return grid;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
