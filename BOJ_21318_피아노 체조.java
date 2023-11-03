import java.io.*;
import java.util.*;

public class Main{
    static int N, Q;
    static int[] arr;
    static int[] cnt;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cnt = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxCnt = 0;
        for(int i=1; i<N; i++){
            if(arr[i-1] > arr[i]){
                maxCnt += 1;

            }
            cnt[i] = maxCnt;
        }

        Q = Integer.parseInt(br.readLine());
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(cnt[b - 1] - cnt[a - 1]).append("\n");
        }

        System.out.println(sb);
    }
}