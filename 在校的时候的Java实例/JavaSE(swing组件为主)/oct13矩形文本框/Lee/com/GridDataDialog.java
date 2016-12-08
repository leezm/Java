package Lee.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Lee.com.domain.GridData;

public class GridDataDialog extends JDialog {
	private GridData data = null;
	
	JRadioButton[] radios = new JRadioButton[8];
	
	private JTextField rowsField;
	private JTextField colsField;
	private JButton ok;
	private JButton cancel;
	private JButton yy;
	
	public GridDataDialog(Frame owner, String title){
		super(owner,title,true);
		JPanel center = new JPanel(new GridLayout(2,2,1,1));
		rowsField = new JTextField();
		colsField = new JTextField();
		
		center.add(new Label("行数："));
		center.add(rowsField);
		center.add(new Label("列数："));
		center.add(colsField);
		
		String[] titles = {"白色","红色","绿色","蓝色","青色","品红","黄色","黑色"};
		final Color[] colors = {Color.white,Color.red,Color.green,Color.blue,Color.cyan,Color.magenta,Color.yellow,Color.black};
		ButtonGroup group = new ButtonGroup();
		JPanel radioPanel = new JPanel();
		for(int i = 0; i < radios.length; i++){
			radios[i] = new JRadioButton(titles[i]);
			group.add(radios[i]);
			radioPanel.add(radios[i]);
		}
		radios[0].setSelected(true);
		
		JPanel center1 = new JPanel(new BorderLayout());
		center1.add(center);
		center1.add(radioPanel,BorderLayout.SOUTH);
		
		
		JPanel south = new JPanel();
		ok = new JButton("确定");
		cancel = new JButton("取消");
		yy    = new JButton("应用");
		south.add(ok);
		south.add(cancel);
		south.add(yy);
		
		Container c = this.getContentPane();
		c.add(center1,BorderLayout.CENTER);
		c.add(south,BorderLayout.SOUTH);
		
		this.setSize(320,150);
		ok.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int rows = Integer.parseInt(rowsField.getText());
						int cols = Integer.parseInt(colsField.getText());
						data = new GridData();
						data.setRows(rows);
						data.setCols(cols);
						Color color = null;
						for(int i = 0; i < radios.length; i++){
							if(radios[i].isSelected()){
								color = colors[i];
								break;
							}
						}
						data.setColor(color);
						
						setVisible(false);
						}
					
				});
		cancel.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						data = null;
						setVisible(false);
					}
					
				});
		yy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rows = Integer.parseInt(rowsField.getText());
				int cols = Integer.parseInt(colsField.getText());
				data = new GridData();
				data.setRows(rows);
				data.setCols(cols);
				Color color = null;
				for(int i = 0; i < radios.length; i++){
					if(radios[i].isSelected()){
						color = colors[i];
						break;         
					}
				}
				data.setColor(color);
				setVisible(false);
			}
		});
	}
	public void setGridData(GridData d){
		rowsField.setText(String.valueOf(d.getRows()));
		colsField.setText(String.valueOf(d.getCols()));
	}
	public GridData showDialog(){
		this.setVisible(true);
		return data;
	}
}
