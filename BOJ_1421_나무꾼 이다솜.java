import java.io.*;
import java.util.*;

public class Main {

    static int N, C, W, maxValue;
    static long sum, ANS;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(maxValue < arr[i])
                maxValue = arr[i];
        }

        // i : 나무토막 길이
        for(int i=1; i<=maxValue; i++){
            sum = 0;

            for(int j=0; j<N; j++){
                // j번째 나무를 i길이로 자르고 파는데 드는 비용

                int treeCnt = arr[j]/i; // 나오는 나무 개수
                int cutCnt = 0; // 자르는 횟수
                if(arr[j] % i == 0)
                    cutCnt = treeCnt - 1;
                else
                    cutCnt = treeCnt;

                int tmpCost = (treeCnt * W * i) - (cutCnt * C);
                if(tmpCost < 0)
                    continue;

                sum += tmpCost;
            }

            if(sum > ANS)
                ANS = sum;
        }

        System.out.println(ANS);
    }
}