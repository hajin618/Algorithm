import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int row, col, ANS;
    static int[][] arr;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr =  new int[N+1][M+1];
        arr[1][1] = 1;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                arr[i][j] += arr[i-1][j] + arr[i][j-1];
            }
        }

        if(K == 0){
            ANS = arr[N][M];
        }
        else{
            int num = 1;
            L : for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    if(num == K){
                        row = i;
                        col = j;
                        break L;
                    }
                    num += 1;
                }
            }

            int num1 = arr[row][col];

            arr = new int[N+1][M+1];
            arr[row][col] = 1;
            for(int i=row; i<=N; i++){
                for(int j=col; j<=M; j++){
                    arr[i][j] += arr[i-1][j] + arr[i][j-1];
                }
            }

            int num2 = arr[N][M];

            ANS = num1 * num2;
        }

        System.out.println(ANS);
    }
}