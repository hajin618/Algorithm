import java.io.*;
import java.util.*;
public class Main {

    static int N, M;
    static int[][] arr;
    static int ANS = 0;
    static int[] nr = {-1, 1, 0, 0};
    static int[] nc = {0, 0, -1, 1};

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0){
                    ANS += 1;
                    bfs(i, j);
                }
            }
        }

        System.out.println(ANS);
    }

    public static void bfs(int i, int j){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(i, j));

        while(!queue.isEmpty()){
            Node now = queue.poll();
            arr[now.x][now.y] = 1;

            for(int p=0; p<4; p++){
                int nextX = now.x + nr[p];
                int nextY = now.y + nc[p];

                if(nextX == -1)
                    nextX = N-1;
                if(nextX == N)
                    nextX = 0;
                if(nextY == -1)
                    nextY = M-1;
                if(nextY == M)
                    nextY = 0;

                if(arr[nextX][nextY] == 0){
                    queue.add(new Node(nextX, nextY));
                    arr[nextX][nextY] = 1;
                }
                    
            }
        }
    }
}