import java.io.*;
import java.util.*;

public class Main{

    static int T, N;
    static long[][] dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        dp = new long[65][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        for(int testCase = 1; testCase <= T; testCase++){
            N = Integer.parseInt(br.readLine());

            long tmp = 0;
            for(int i=0; i<10; i++){
                tmp += dp[N][i];
            }
            sb.append(tmp).append("\n");
        }

        System.out.println(sb);
    }
}