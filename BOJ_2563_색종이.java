import java.io.*;
import java.util.*;

public class Main {

    static int N, ANS;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int r, c;
        arr = new int[101][101];
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for(int ii=0; ii<10; ii++){
                for(int jj=0; jj<10; jj++){
                    arr[r+ii][c+jj] = 1;
                }
            }
        }

        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                if(arr[i][j] == 1){
                    ANS += 1;
                }
            }
        }

        System.out.println(ANS);
    }
}