package wang.com.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import wang.com.helper.StudentScoreConstants;

public class StudentScoreView extends JPanel {

	private JTable dataTable;
	private DefaultTableModel dataModel;
	private int addIndex;
	private int deleteIndex;
	private int updateIndex;
	private int rowCount;
	
	public StudentScoreView(){
		setLayout(new BorderLayout());
		
		
	}
	
	public void setMode(DefaultTableModel model){
		this.dataModel = model;
	}
	
	public ArrayList<Object[]> getData(){
		ArrayList<Object[]> datas = new ArrayList<Object[]>();
		
		for(int row = 0; row < rowCount; row++){
			byte operCode = -1;
			Boolean add = (Boolean)dataModel.getValueAt(row, addIndex);
			Boolean delete = (Boolean)dataModel.getValueAt(row, deleteIndex);
			Boolean update = (Boolean)dataModel.getValueAt(row, updateIndex);
			if(add.booleanValue()){
				operCode = StudentScoreConstants.ADD;
			}else if(delete.booleanValue()){
				operCode = StudentScoreConstants.DELETE;
			}else if(update.booleanValue()){
				operCode = StudentScoreConstants.UPDATE;
			}
			if(operCode != -1){
				Object[] rowData = new Object[addIndex + 1];
				for(int col = 0; col < addIndex; col++){
					rowData[col] = dataModel.getValueAt(row, col);
				}
				rowData[addIndex] = new Byte(operCode);
				datas.add(rowData);
			}
		}
		return datas;
	}
	
	public void setData(ArrayList<Object[]> rowData){
		int count = rowData.size();
		for(int row = 0; row < count; row++){
			Object[] data = rowData.get(row);
			for(int column = 0; column < data.length; column++){
				dataModel.setValueAt(data[column], row, column);
			}
			dataModel.setValueAt(Boolean.FALSE, row, addIndex);
			dataModel.setValueAt(Boolean.FALSE, row, deleteIndex);
			dataModel.setValueAt(Boolean.FALSE, row, updateIndex);
		}
	}
}
