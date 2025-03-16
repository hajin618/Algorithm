import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n > 0){
            System.out.println(1);
        }
        else if(n == 0){
            System.out.println(0);
        }
        else{
            n = -n;
            if(n%2 == 0) System.out.println(-1);
            else System.out.println(1);
        }

        dp = new int[1000001];
        dp[1] = 1;
        dp[2] = 1;

        if(n >= 3){
            for(int i=3; i<=n; i++){
                dp[i] = (dp[i-2] + dp[i-1]) % 1000000000;
            }
        }

        System.out.println(dp[n]);
    }
}