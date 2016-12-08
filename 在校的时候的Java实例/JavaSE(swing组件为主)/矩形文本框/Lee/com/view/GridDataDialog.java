package Lee.com.view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Lee.com.domain.Grid;

public class GridDataDialog extends JDialog {
	private JTextField rowField;
	private JTextField columnField;
	private JRadioButton[] radios = new JRadioButton[8];
	private JButton okButton;
	private JButton cancelButton;
	private JButton applyButton;
	
	private Grid grid;
	
	public GridDataDialog(Frame owner, String title){
		super(owner, title, false);
		
		grid = ((MainFrame)owner).getGrid();
		
		JPanel fieldPanel = new JPanel(new GridLayout(2, 2, 1, 1));
		JLabel rowLabel = new JLabel("行数：");
		rowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rowField = new JTextField(String.valueOf(grid.getRowCount()));
		JLabel columnLabel = new JLabel("列数：");
		columnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		columnField = new JTextField(String.valueOf(grid.getColumnCount()));
		fieldPanel.add(rowLabel);
		fieldPanel.add(rowField);
		fieldPanel.add(columnLabel);
		fieldPanel.add(columnField);
		
		JPanel radioPanel = new JPanel();
		String[] colorNames = {
				"白色","红色","绿色","蓝色","青色","品红","黄色","黑色"
		};
		ButtonGroup group = new ButtonGroup();
		for(int i = 0; i < radios.length; i++){
			radios[i] = new JRadioButton(colorNames[i]);
			group.add(radios[i]);
			radioPanel.add(radios[i]);
		}
		radios[grid.getColorIndex()].setSelected(true);
		
		JPanel center = new JPanel(new BorderLayout());
		center.add(fieldPanel, BorderLayout.CENTER);
		center.add(radioPanel, BorderLayout.SOUTH);
		
		JPanel south = new JPanel();
		okButton = new JButton("确定");
		cancelButton = new JButton("取消");
		applyButton = new JButton("应用");
		south.add(okButton);
		south.add(cancelButton);
		south.add(applyButton);
		
		Container c = this.getContentPane();
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		
		this.setSize(480,150);
		
		okButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int rowCount = Integer.parseInt(rowField.getText());
						int columnCount = Integer.parseInt(columnField.getText());
						int colorIndex = -1;
						for(int i = 0; i < radios.length; i++){
							if(radios[i].isSelected()){
								colorIndex = i;
								break;
							}
						}
						grid.setRowCount(rowCount);
						grid.setColumnCount(columnCount);
						grid.setColor(colorIndex);
						
						setVisible(false);
					}
				});
		cancelButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						setVisible(false);
					}
					
				});
		applyButton.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int rowCount = Integer.parseInt(rowField.getText());
						int columnCount = Integer.parseInt(columnField.getText());
						int colorIndex = -1;
						for(int i = 0; i < radios.length; i++){
							if(radios[i].isSelected()){
								colorIndex = i;
								break;
							}
						}
						grid.setRowCount(rowCount);
						grid.setColumnCount(columnCount);
						grid.setColor(colorIndex);
					}
					
				});
		
	}
	public void showDialog(){
		this.setVisible(true);
	}
}
