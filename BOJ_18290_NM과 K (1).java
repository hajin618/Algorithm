import java.io.*;
import java.util.*;

public class Main{
    static int N, M, K;
    static int[][] arr;
    static boolean[][] visited;
    static int ANS = Integer.MIN_VALUE;
    static int[] nr = {-1, 1, 0, 0};
    static int[] nc = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0, 0, 0);

        System.out.println(ANS);
    }

    public static void combination(int x, int y, int idx, int sum){
        if(idx == K){
            ANS = Math.max(ANS, sum);
//            System.out.println(ANS);
            return;
        }

        for(int i=x; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    // 상하좌우 visited false 면
                    if(isFalse(i, j)){
                        visited[i][j] = true;
                        combination(i, j, idx + 1, sum + arr[i][j]);
                        visited[i][j] = false;
                    }
                }
            }
        }
    }

    public static boolean isFalse(int x, int y){

        for(int p=0; p<4; p++){
            int nextX = x + nr[p];
            int nextY = y + nc[p];

            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                continue;
            if(visited[nextX][nextY]){
                return false;
            }
        }

        return true;
    }
}