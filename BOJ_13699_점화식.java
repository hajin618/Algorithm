import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new long[36];
        arr[0] = 1;

        for(int i=1; i<=N; i++){
            for(int j=0; j<i; j++){
                arr[i] += arr[j] * arr[i-j-1];
            }
        }

        System.out.println(arr[N]);
    }
}