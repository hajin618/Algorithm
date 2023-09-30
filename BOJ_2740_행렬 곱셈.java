import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st. nextToken());
        K = Integer.parseInt(st.nextToken());
        B = new int[M][K];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        C = new int[N][K];

        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                for(int k=0; k<M; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                sb.append(C[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}