import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[] arr;
    static int ANS;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        ANS = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[N-1];

        while(left <= right){
            int cnt = 0;
            int mid = (right + left) / 2;

            for(int i=0; i<N; i++){
                cnt += arr[i] / mid;
            }

            // 조카 수보다 많으면 정답 가능, 최대값 찾기
            if(cnt >= M){
                if(ANS < mid)
                    ANS = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        System.out.println(ANS);
    }
}