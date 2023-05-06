import java.util.*;
import java.io.*;

public class Main {
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while(true){
            // 합이 S보다 크거나 같으면
            if(sum >= S){
                // 길이 비교
                ans = Math.min(ans, right - left);
                // 왼쪽 값 빼기
                sum -= arr[left];
                left += 1;
            }
            // 합이 S보다 작고 right가 끝에 도달하면 멈추기
            else if(right == N){
                break;
            }
            // 합이 S보다 작으면
            else{
                // 오른쪽 값 더하기
                sum += arr[right];
                right += 1;
            }
        }

        if(ans == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(ans);
    }
}