import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                if(s.charAt(j) == '#'){
                    arr[i][j] = 1;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 1){
                    if(j+1<M && arr[i][j+1] == 0){
                        arr[i][j+1] = 2;
                    }
                    if(i+1<N && arr[i+1][j] == 0){
                        arr[i+1][j] = 2;
                    }
                    if(i+1<N && j+1<M && arr[i+1][j+1] == 0){
                        arr[i+1][j+1] = 2;
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0){
                    sb.append('.');
                }
                else{
                    sb.append('#');
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }
}