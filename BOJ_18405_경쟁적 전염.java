import java.io.*;
import java.util.*;

public class Main{
    static int N, K, S, X, Y;
    static int[][] arr;
    static int[] nr = {-1, 1, 0, 0};
    static int[] nc = {0, 0, -1, 1};

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int num;
        int sec;

        Node(int x, int y, int num, int sec){
            this.x = x;
            this.y = y;
            this.num = num;
            this.sec = sec;
        }

        @Override
        public int compareTo(Node o){
            if(this.sec == o.sec)
                return this.num - o.num;
            else
                return this.sec - o.sec;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] != 0){
                    pq.add(new Node(i, j, arr[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.sec >= S)
                continue;

            for(int p=0; p<4; p++) {
                int nextX = now.x + nr[p];
                int nextY = now.y + nc[p];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || arr[nextX][nextY] != 0){
                    continue;
                }
                arr[nextX][nextY] = now.num;
                pq.add(new Node(nextX, nextY, now.num, now.sec + 1));

            }
        }

        System.out.println(arr[X][Y]);
    }
}