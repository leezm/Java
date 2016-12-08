package Lee.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Lee.com.domain.GridData;

public class MainFrame extends JFrame {
	private GridDataDialog dialog = null;
	public MainFrame(){
		final GridView view = new GridView();
		
		JPanel south = new JPanel();
		JButton openButton = new JButton("打开");
		JButton exitButton = new JButton("退出");
		south.add(openButton);
		south.add(exitButton);
		
		Container  c = this.getContentPane();
		c.add(view);
		c.add(south,BorderLayout.SOUTH);
		
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		openButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(dialog == null){
							dialog = new GridDataDialog(MainFrame.this,"选项");
						}
						GridData d = new GridData(view.getRows(),view.getCols(),Color.black);
						dialog.setGridData(d);
						GridData data = dialog.showDialog();
						if(data == null){
							return;
						}
						view.setRows(data.getRows());
						view.setCols(data.getCols());
						view.setColor(data.getColor());
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
	public static void main(String[] args){
		new MainFrame();
		
	}
}
