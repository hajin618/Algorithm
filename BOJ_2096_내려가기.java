import java.io.*;
import java.util.*;

public class Main {
    static int N, MAX, MIN;
    static int[][] arr;
    static int[][] max;
    static int[][] min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][3];
        max = new int[N][3];
        min = new int[N][3];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<3; i++){
            max[0][i] = arr[0][i];
            min[0][i] = arr[0][i];
        }

        // max[i][j] = arr[i][j] 선택 했을 때 최댓값
        // min[i][j] = arr[i][j] 선택 했을 때 최소값
        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                if(j == 0){
                    max[i][j] = Math.max(max[i-1][0] + arr[i][j], max[i-1][1] + arr[i][j]);
                    min[i][j] = Math.min(min[i-1][0] + arr[i][j], min[i-1][1] + arr[i][j]);
                }
                else if(j == 1){
                    max[i][j] = Math.max(max[i-1][0] + arr[i][j], Math.max(max[i-1][1] + arr[i][j], max[i-1][2] + arr[i][j]));
                    min[i][j] = Math.min(min[i-1][0] + arr[i][j], Math.min(min[i-1][1] + arr[i][j], min[i-1][2] + arr[i][j]));
                }
                else{
                    max[i][j] = Math.max(max[i-1][1] + arr[i][j], max[i-1][2] + arr[i][j]);
                    min[i][j] = Math.min(min[i-1][1] + arr[i][j], min[i-1][2] + arr[i][j]);
                }
            }
        }

        MAX = max[N-1][0];
        MIN = min[N-1][0];

        for(int i=1; i<3; i++){
            if(MAX < max[N-1][i])
                MAX = max[N-1][i];

            if(MIN > min[N-1][i])
                MIN = min[N-1][i];
        }

        System.out.println(MAX + " " + MIN);
    }
}