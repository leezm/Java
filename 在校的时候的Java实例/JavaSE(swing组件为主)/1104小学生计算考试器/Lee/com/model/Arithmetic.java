package Lee.com.model;

public class Arithmetic {

	private int left;
	private int right;
	private int operatorCode;
	private int answer;
	
	private int result;
	
	private static final int ADD = 0;
	private static final int SUBTRACT = 1;
	private static final int MULTIPLY = 2;
	private static final int DEVIDED = 3;
	
	private Arithmetic(){
		
	}
	public static Arithmetic createArithmetic(){
		Arithmetic arithmetic = new Arithmetic();
		int left = (int)(Math.random() * 90) + 10;
		int right = (int)(Math.random() * 90) + 10;
		int op = (int)(Math.random() * 4);
		if(op == Arithmetic.SUBTRACT){
			if(left < right){
				int temp = left;
				left = right;
				right = temp;
			}
		}
		if(op == Arithmetic.DEVIDED){
			if(left < right){
				int temp = left;
				left = right;
				right = temp;
			}
			if(left % right != 0){
				left -= left % right;
			}
		}
		
		arithmetic.left = left;
		arithmetic.right = right;
		arithmetic.operatorCode = op;
		
		return arithmetic;
	}
	public int getLeft() {
		return left;
	}
	public int getRight() {
		return right;
	}
	public int getResult() {
		return result;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
		
		int temp = 0;
		switch(operatorCode){
		case 0:
			temp = left + right;
			break;
		case 1:
			temp = left - right;
			break;
		case 2:
			temp = left * right;
			break;
		case 3:
			temp = left / right;
			break;
		}
		
		if(temp == answer){
			result = 1;
		}else{
			result = 0;
		}
	}

	public static String getOperator(int op){
		String s = null;
		switch(op){
		case 0:
			s = "+";
			break;
		case 1:
			s = "-";
			break;
		case 2:
			s = "*";
			break;
		case 3:
			s = "/"; 
			break; 
		}
		return s;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append(left + "  " + getOperator(operatorCode) + "  " + right + "  =  " + answer + "        ");
		if(result == 1){
			buffer.append("ÕýÈ·\n");
		}else{
			buffer.append("´íÎó\n");
		}
		return buffer.toString();
	}

	
}
