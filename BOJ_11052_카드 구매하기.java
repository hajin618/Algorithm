import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[1001];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[1001];

        dp[0] = 0;

        // dp[i] : i개 구매했을 때 최댓값
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
            }
        }

        System.out.println(dp[N]);
    }
}