import java.io.*;
import java.util.*;

public class Main {
    static int N, L, ANS;
    static int[] arr, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        sum = new int[N+1];
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            sum[i] = sum[i-1] + arr[i];
            if(i > L){
                sum[i] -= arr[i-L];
            }
            if(sum[i] >= 129 && sum[i] <= 138){
                ANS += 1;
            }
        }

        System.out.println(ANS);
    }
}