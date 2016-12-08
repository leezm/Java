package Lee.com;
import java.math.*;
public class Test2 {

        /**
         * @param args
         */
        public static void main(String[] args) {
                // TODO Auto-generated method stub
            for(int x=11;true;x++){
            	int y = x * x * x;
            	int z = x * x * x * x;
            	System.out.println("x =" + x + "\ty = "+y+"\tz +" +z);
            	if(y >= 10000 || z >= 1000000){
            		break;
            	}
               
            }
        }
}
