import java.io.*;
import java.util.*;

public class Main{

    static int a, b, c;
    static int dp[][][];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        dp = new int[21][21][21];

        while(true){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1){
                break;
            }

            sb.append("w(" + a + ", " + b + ", " + c + ") = ").append(w(a ,b ,c)).append('\n');
        }

        System.out.println(sb);
    }

    static int w(int a, int b, int c){
        if(0<=a && a<=20 && 0<=b && b<=20 && 0<=c && c<=20 && dp[a][b][c] != 0){
            return dp[a][b][c];
        }

        if(a<=0 || b<=0 || c<=0){
            return 1;
        }

        if(a>20 || b>20 || c>20){
            return dp[20][20][20] = w(20, 20, 20);
        }

        if(a<b && b<c){
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }

        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }
}