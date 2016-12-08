package Lee.com;

public class Weight {

    public static void main(String[]args) {
       int input = 106;
        int[] a , b , c , d , e;
        a = b = c = d = e = new int[]{-1,0,1};
        for (int ai : a){
            for (int bi : b){
                for (int ci : c){
                    for (int di : d){
                        for (int ei : e){
                            if (input == ei*81 + di*27 + ci*9 + bi*3 + ai*1){
                                System.out.println("("+ ei*81 + ")+(" + di*27 + ")+(" + ci*9 + ")+(" + bi*3 + ")+(" + ai*1 +")");
                           }
                        }
                    }
                }
            }
        }
    }
}
