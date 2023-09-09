import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main{
    static int T;
    static long N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            N = Long.parseLong(br.readLine());
            BigInteger bi = new BigInteger(String.valueOf(N));

            if(bi.isProbablePrime(10)){
                System.out.println(N);
            }
            else{
                System.out.println(bi.nextProbablePrime());
            }
        }
    }
}