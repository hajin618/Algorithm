import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(2);
        }
        else{
            int i = N;
            while(true){
                if(isPal(i) && isPrime(i)){
                    System.out.println(i);
                    break;
                }
                i += 1;
            }
        }
    }

    public static boolean isPal(int i){
        String s = Integer.toString(i);
        int len = s.length();
        for(int j=0; j<=len/2; j++){
            if(s.charAt(j) != s.charAt(len-j-1)){
                return false;
            }
        }

        return true;
    }

    public static boolean isPrime(int i){
        double sqrt = Math.sqrt(i);
        for(int j=2; j<= sqrt; j++){
            if(i % j == 0){
                return false;
            }
        }

        return true;
    }
}