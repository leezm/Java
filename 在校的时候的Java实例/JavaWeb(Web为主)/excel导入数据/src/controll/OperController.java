package controll;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class OperController {

	public OperController() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JMenuBar getBar(){
		JMenuBar bar = new JMenuBar();
		JMenu fileMenu = new JMenu("文件（F）");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem dataImport = new JMenuItem("数据导入");
		JMenuItem dataExport = new JMenuItem("数据导出");
		JMenuItem exitItem = new JMenuItem("退出");
		dataImport.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JFileChooser chooser = new JFileChooser();
						int option = chooser.showOpenDialog(null);
						if(option == JFileChooser.APPROVE_OPTION){
							try{
								File file = chooser.getSelectedFile();
								String filename = file.getAbsolutePath();
								InputStream is = new FileInputStream(filename);
								int len = is.available();
								byte[] bt = new byte[len];
								is.read(bt);
								String str = new String(bt);
								is.close();
							}catch(Exception ex){
								ex.printStackTrace();
							}
						}
					}
				});
		dataExport.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
		exitItem.addActionListener(
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}
				});
		fileMenu.add(dataImport);
		fileMenu.add(dataExport);
		fileMenu.add(exitItem);
		bar.add(fileMenu);
		return bar;
	}
}
