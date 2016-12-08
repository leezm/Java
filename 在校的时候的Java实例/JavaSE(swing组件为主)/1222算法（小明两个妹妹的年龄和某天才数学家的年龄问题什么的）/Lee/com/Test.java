package Lee.com;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    for(int i = 0; i < 20; i++) {
	        for(int j = i; j < 20; j++) {
	            if(i * j == (i + j) * 6 && j - i <= 8 && i != j){
	                System.out.println(i);
	                System.out.println(j);
	            }
	        }
	    }
	
	}

}
