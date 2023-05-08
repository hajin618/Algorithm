import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int ANS = 0;

        while(true){
            // 합이 M보다 크거나 같
            if(sum >= M){
                if (sum == M){
                    ANS += 1;
                }
                sum -= arr[left];
                left += 1;
            }
            // 합이 M보다 작고 범위 벗어나면
            else if(right == N)
                break;
            else{
                sum += arr[right];
                right += 1;
            }
        }
        System.out.println(ANS);
    }
}