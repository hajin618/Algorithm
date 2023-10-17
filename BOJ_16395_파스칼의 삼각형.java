import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[30][30];

        arr[0][0] = 1;
        for(int i=1; i<30; i++){
            for(int j=0; j<=i; j++){
                if(j == 0){
                    arr[i][j] = 1;
                    continue;
                }
                else if(j == i){
                    arr[i][j] = 1;
                    continue;
                }
                arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
            }
        }
        System.out.println(arr[N-1][K-1]);
    }
}