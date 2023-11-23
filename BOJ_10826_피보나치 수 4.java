import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N;
    static BigInteger[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        if(N == 0){
            System.out.println("0");
        }
        else if(N == 1){
            System.out.println("1");
        }
        else{
            arr = new BigInteger[N+1];

            arr[0] = BigInteger.ZERO;
            arr[1] = BigInteger.ONE;
            for(int i=2; i<=N; i++){
                arr[i] = arr[i-2].add(arr[i-1]);
            }

            System.out.println(arr[N]);
        }
    }
}