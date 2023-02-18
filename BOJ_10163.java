import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[][] arr = new int[1001][1001];
    public static int[] ans = new int[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int p = x; p < x+h; p++){
                for(int q = y; q < y+w; q++){
                    arr[p][q] = i;
                }
            }
        }

        for(int i=0; i<1001; i++){
            for(int j=0; j<1001; j++){
                ans[arr[i][j]] += 1;
            }
        }

        for(int i=1; i<=N; i++)
            System.out.println(ans[i]);
    }
}