import java.io.*;
import java.util.*;

public class Main {

    static int N, ANS;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sum = new int[N+1][N+1];
        int tmp = 0;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                tmp = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + tmp;
            }
        }

        ANS = Integer.MIN_VALUE;
        // (i, j) ~ (i+k, j+k)
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=0; k<=N; k++){
                    if(i+k > N || j+k > N)
                        break;
                    tmp = sum[i+k][j+k] - sum[i-1][j+k] - sum[i+k][j-1] + sum[i-1][j-1];
                    ANS = Math.max(ANS, tmp);
                }
            }
        }

        System.out.println(ANS);
    }
}