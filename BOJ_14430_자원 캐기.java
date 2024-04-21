import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for(int i=1; i<M; i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        for(int i=1; i<N; i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for(int i=1; i<N; i++){
            for(int j=1; j<M; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + arr[i][j];
            }
        }

        System.out.println(dp[N-1][M-1]);
    }
}