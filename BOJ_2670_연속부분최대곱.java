import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static double[] arr, dp;
    static double ANS;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new double[N];
        dp = new double[N];
        for(int i=0; i<N; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        ANS = arr[0];
        dp[0] = arr[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1] * arr[i], arr[i]);
            ANS = Math.max(ANS, dp[i]);
        }
//        System.out.println(ANS);
//        System.out.println(Math.round(ANS * 1000) / 1000.0);
        System.out.println(String.format("%.3f", ANS));
    }
}