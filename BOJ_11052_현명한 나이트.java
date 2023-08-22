import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int N, M, X, Y;
    static int[][] arr, ansArr;
    static int[][] enemy;
    static boolean[][] visited;
    static int nr[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int nc[] = {-1, 1, -2, 2, -2, 2, -1, 1};

    static Queue<Node> queue;
    static class Node{
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());   // 시작점
        Y = Integer.parseInt(st.nextToken());   // 시작점

        arr = new int[N][N];
        ansArr = new int[N][N];
        enemy = new int[M][2];
        visited = new boolean[N][N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            enemy[i][0] = a - 1;
            enemy[i][1] = b - 1;
            arr[a - 1][b - 1] = -1;     // 상대편 말 있는 곳 -1로
        }

        BFS();

        for(int i=0; i<M; i++){
            System.out.print(ansArr[enemy[i][0]][enemy[i][1]] + " ");
        }

    }

    public static void BFS(){
        int ans = 0;
        queue = new LinkedList<>();
        visited[X-1][Y-1] = true;
        queue.add(new Node(X-1, Y-1, 0));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;

            if(arr[nowX][nowY] == -1){
                ansArr[nowX][nowY] = node.cnt;
                ans += 1;
            }

            if(ans == M)
                break;

            for(int p=0; p<8; p++){
                int nextX = nowX + nr[p];
                int nextY = nowY + nc[p];

                if(nextX <0 || nextX >=N || nextY<0 || nextY >=N)
                    continue;
                if(visited[nextX][nextY])
                    continue;

                visited[nextX][nextY] = true;
                queue.add(new Node(nextX, nextY, node.cnt + 1));
            }
        }
    }

}