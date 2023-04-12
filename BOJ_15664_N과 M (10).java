import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    public static int N, M;
    public static int[] arr;
    public static int[] ans;
    public static int[][] lastANS;
    public static int ansIdx = 0;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        ans = new int[M];
        lastANS = new int[100][M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        func(0, 0);

        for(int i=0; i<ansIdx; i++){
            for(int j=0; j<M; j++){
                sb.append(lastANS[i][j]);
                if(j != M-1)
                    sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void func(int idx, int k){

        if(k == M){

            boolean flag2 = false;
            for(int i=0; i<ansIdx; i++){
                boolean flag = false;
                for(int j=0; j<M; j++){
                    // 하나라도 다르면 flag true
                    if(lastANS[i][j] != ans[j]){
                        flag = true;
                    }
                }
                // 같으면
                if(!flag){
                    flag2 = true;
                    break;
                }
            }

            if(!flag2){

                for(int i=0; i<M; i++){
                    lastANS[ansIdx][i] = ans[i];
                }
                ansIdx += 1;
            }
            return;
        }

        for(int i=idx; i<N; i++){
            ans[k] = arr[i];
            func(i+1, k+1);
        }
    }

}