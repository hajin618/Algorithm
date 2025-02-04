import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], (int)1e9);
            }
        }

        for(int i=0; i<M; i++){
            dp[0][i][0] = arr[0][i];
            dp[0][i][1] = arr[0][i];
            dp[0][i][2] = arr[0][i];
        }
        for(int i=1; i<N; i++){
            for(int j=0; j<M; j++){

                if(j == 0){
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][0] + arr[i][j];
                }else if(j == M - 1) {
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + arr[i][j];
                    dp[i][j][1] = dp[i - 1][j][2] + arr[i][j];
                } else {
                    dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
                    dp[i][j][2] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][0]) + arr[i][j];
                }
            }
        }

        int ANS = Integer.MAX_VALUE;
        for(int i=0; i<M; i++){
            for(int j=0; j<3; j++)
                ANS = Math.min(dp[N-1][i][j], ANS);
        }

        System.out.println(ANS);
    }
}