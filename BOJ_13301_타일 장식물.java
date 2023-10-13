import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] len;
    static long[] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        len = new long[81];
        sum = new long[81];

        len[1] = 1;
        len[2] = 1;

        sum[1] = 4;
        sum[2] = 6;

        for(int i=3; i<=N; i++){
            len[i] = len[i-1] + len[i-2];
            sum[i] = sum[i-1] + len[i] * 2;
        }
        System.out.println(sum[N]);
    }
}