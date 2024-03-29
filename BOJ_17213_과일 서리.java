import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[N+1][M+1];

        for(int i=1; i<=M; i++){
            dp[1][i] = 1;
        }
        for(int i=1; i<=N; i++){
            dp[i][i] = 1;
        }
        for(int i=2; i<=N; i++){
            for(int j=i; j<=M; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }

        System.out.println(dp[N][M]);
    }
}