package wang.com.model;

public class Arithmetic {

	private int left;
	private int right;
	private int answer;
	private int operatorCode;
	
	private int result;

	private Arithmetic(){
		
	}
	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
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

	
	public int getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(int operatorCode) {
		this.operatorCode = operatorCode;
	}

	public int getResult() {
		return result;
	}

	public static String getOperator(int code){
		String s = null;
		switch(code){
		case 0:
			s = "+";
			break;
		case 1:
			s = "-";
			break;
		case 2:
			s = "¡Á";
			break;
		case 3:
			s = "¡Â";
			break;
		}
		return s;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer buffer = new StringBuffer();
		buffer.append(left + " " + getOperator(operatorCode) + " " + right + " = " + answer + "  ");
		if(result == 1){
			buffer.append("ÕýÈ·\n");
		}else{
			buffer.append("´íÎó\n");
		}
		return buffer.toString();
	}
	
	public static Arithmetic createArithmetic(){
		Arithmetic arithmetic = new Arithmetic();
		int left = (int)(Math.random() * 90) + 10;
		int right = (int)(Math.random() * 90) + 10;
		int op = (int)(Math.random() * 4);
		
		switch(op){
		case 0:
			break;
		case 1:
			if(left < right){
				int temp = left;
				left = right;
				right = temp;
			}
			break;
		case 2:
			break;
		case 3:
			if(left < right){
				int temp = left;
				left = right;
				right = temp;
			}
			if(left % right != 0){
				left -= (left % right);
			}
			break;
		}
		arithmetic.setLeft(left);
		arithmetic.setOperatorCode(op);
		arithmetic.setRight(right);
		return arithmetic;
	}
	
}
