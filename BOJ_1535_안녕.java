import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] loss;
    static int[] happy;
    static int[] dp;
    static int cheryuk = 100;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        loss = new int[N];
        happy = new int[N];
        dp = new int[100];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            loss[i] = Integer.parseInt(st1.nextToken());
            happy[i] = Integer.parseInt(st2.nextToken());

        }

        for(int i=0; i<N; i++){
            for(int j=99; j >= loss[i]; j--){
                dp[j] = Math.max(dp[j-loss[i]]+happy[i], dp[j]);
            }
        }

        System.out.println(dp[99]);
    }
}