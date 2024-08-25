import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ANS;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[101][101];
        int x1, y1, x2, y2;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int j=x1; j<=x2; j++){
                for(int k=y1; k<=y2; k++){
                    arr[j][k] += 1;
                }
            }
        }

        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){
                if(arr[i][j] > M)
                    ANS += 1;
            }
        }
        System.out.println(ANS);
    }
}