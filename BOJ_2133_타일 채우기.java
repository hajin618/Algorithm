import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        dp[0] = 1;
        if(N % 2 != 0){
            System.out.println(0);
        }
        else{
            for(int i=2; i<=N; i+=2){
                dp[i] = dp[i-2] * 3;
                for(int j=i-4; j>=0; j-=2){
                    dp[i] += dp[j] * 2;
                }
            }

            System.out.println(dp[N]);
        }
    }
}