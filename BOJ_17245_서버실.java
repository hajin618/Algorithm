import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
    static long sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int left = 0;
        int right = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                sum += arr[i][j];
                if(arr[i][j] > right)
                    right = arr[i][j];
            }
        }
        
        int mid = 0;
        while(left + 1 < right){
            mid = (left + right) / 2;
            long cnt = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int now = arr[i][j];
                    if(now >= mid){
                        now = mid;
                    }
                    cnt += now;
                }
            }

            if(((double) cnt / sum) >= 0.5){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        System.out.println(right);
    }
}