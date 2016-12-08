package Lee.com;

import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class NumberField extends JTextArea {

	@Override
	protected Document createDefaultModel() {
		// TODO Auto-generated method stub
		return new CharDocument();
	}
}

class  CharDocument extends PlainDocument{

	@Override
	public void insertString(int offs, String str, AttributeSet a)
			throws BadLocationException {
		// TODO Auto-generated method stub
		if(str == null){
			return;
		}
		CharArray array = new CharArray();
		
		super.insertString(offs,array.toString(), a);
	}			
}

class CharArray{
	private char[] arrs = new char[10];
	private int pos = 0;
	/*public CharArray(int size){
		arrs = new char[size];
		pos = 1;
		}*/
	public void append (char ch){
			if(pos < arrs.length){
				arrs[pos] = ch;
				pos++;
			}else{
				char[] arrs1 = new char[arrs.length + 10];
				for(int i = 0; i < pos; i++){
					arrs1[i] = arrs[i];
				}
				arrs1[pos] = ch;
				arrs = arrs1;
			}
			pos++;
	}
	public boolean remove(int index){
		if(index >= pos){
			return false;
		}else{	
			for(int i = 0; i < pos;i++){
				arrs[i] = arrs[i+1];
				pos--;	
		}
		return true;
	}
}
	public char getAt(int index){
		if(index > arrs.length||index < 0){
			throw new RuntimeException("ÏÂ±êÒì³£");
		}
		return arrs[index];
	}
		
	public int getLength(){
		return pos;
	}	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
	
