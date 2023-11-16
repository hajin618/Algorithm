import java.io.*;
import java.util.*;

public class Main {

    static int N, M, sX, sY, eX, eY;
    static char[][] arr;
    static boolean[][] visited;
    static int ANS;
    static int[] nr = {-1, 1, 0, 0};
    static int[] nc = {0, 0, -1, 1};

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int cnt;

        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o){
            return this.cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sX = Integer.parseInt(st.nextToken()) - 1;
        sY = Integer.parseInt(st.nextToken()) - 1;
        eX = Integer.parseInt(st.nextToken()) - 1;
        eY = Integer.parseInt(st.nextToken()) - 1;

        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        Dijkstra();

        System.out.println(ANS);
    }

    public static void Dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(sX, sY, 0));
        visited[sX][sY] = true;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.x == eX && now.y == eY){
                ANS = now.cnt;
                return;
            }

            for(int p=0; p<4; p++){
                int nextX = now.x + nr[p];
                int nextY = now.y + nc[p];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visited[nextX][nextY]){
                    continue;
                }

                visited[nextX][nextY] = true;

                if(arr[nextX][nextY] == '0')
                    pq.add(new Node(nextX, nextY, now.cnt));
                else
                    pq.add(new Node(nextX, nextY, now.cnt + 1));
            }
        }
    }
}