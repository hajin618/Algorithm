import java.io.*;
import java.util.*;

public class Main{
    static int[][] arr;
    static int T;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        arr = new int[15][15];

        for(int i=1; i<=14; i++){
            arr[0][i] = i;
        }

        for(int i=1; i<=14; i++){
            for(int j=1; j<=14; j++){
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            sb.append(arr[a][b]).append("\n");
        }
        System.out.println(sb);
    }
}