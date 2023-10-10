import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] arr;
    static int[] cnt;
    static int CNT = 0;
    static int ANS = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        cnt = new int[100001];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;

        while(true){
            if(right == N){
                break;
            }

            if(cnt[arr[right]] + 1 > K){
                cnt[arr[left]] -= 1;
                left += 1;
                CNT -= 1;
            }
            else{
                cnt[arr[right]] += 1;
                CNT += 1;
                ANS = Math.max(CNT, ANS);
                right += 1;
            }
        }
        System.out.println(ANS);
    }
}