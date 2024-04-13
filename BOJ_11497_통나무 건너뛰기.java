import java.io.*;
import java.util.*;

public class Main {

    static int T, N, MIN;
    static int[] arr, ans;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < T; testCase++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            ans = new int[N];
            MIN = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = 0;
            int right = N - 1;

            for(int i=0; i<N; i++){
                if(i % 2 == 0){
                    ans[left] = arr[i];
                    left += 1;
                }
                else{
                    ans[right] = arr[i];
                    right -= 1;
                }
            }

            for(int i=1; i<N; i++){
                MIN = Math.max(MIN, Math.abs(ans[i] - ans[i-1]));
            }

            sb.append(MIN).append("\n");
        }

        System.out.println(sb);
    }
}