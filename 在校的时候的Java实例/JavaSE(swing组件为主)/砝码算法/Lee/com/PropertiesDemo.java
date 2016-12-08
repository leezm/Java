package Lee.com;

import java.io.InputStream;



public class PropertiesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] bases = {1,3,9,27,81};
		int[] array = {0,0,0,0,0};
		
		int value = 0;
		try{
			value = inputNumber();
			for(int i = 0; value != 0; i++){
				array[i] = value % 3;
				value = value / 3;
			}
			
			//....
			
			for(int i = 0; i < 5; i++){
				System.out.print((bases[i] * array[i])+ "  ");
			}
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		
	}

	private static int inputNumber(){
		InputStream is = System.in;
		int value = 0;
		try{
			is.mark(100);
			
			is.read();
			is.reset();
			int len = is.available();
			
			for(int i = 0; i < len - 2; i++){
				int ch = is.read();
				if(ch >= 48 && ch <= 57){
					value = 10 * value + (ch-48);
				}else{
					throw new RuntimeException("·Ç·¨×Ö·û");
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return value;
	}
}
