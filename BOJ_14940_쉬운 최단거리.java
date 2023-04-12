import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static int startX, startY;
    public static int N, M;
    public static int[][] arr;
    public static int[] nr = {-1, 1, 0, 0};
    public static int[] nc = {0, 0, -1, 1};
    public static boolean[][] visited;

    public static class Node{
        int i;
        int j;
        int cnt;
        Node(int i, int j, int cnt){
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(startX, startY, 0));
        arr[startX][startY] = 0;
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int p=0; p<4; p++){
                int nextX = node.i + nr[p];
                int nextY = node.j + nc[p];

                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M && arr[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    arr[nextX][nextY] = node.cnt + 1;
                    visited[nextX][nextY] = true;
                    queue.add(new Node(nextX, nextY, node.cnt + 1));
                }
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 1 && !visited[i][j])
                    arr[i][j] = -1;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}