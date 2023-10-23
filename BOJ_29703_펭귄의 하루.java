import java.io.*;
import java.util.*;

public class Main{

    static int N, M;
    static char[][] arr;
    static int startX, startY;
    static int homeX, homeY;
    static boolean[][] visited;
    static int[] nr = {-1, 1, 0, 0};
    static int[] nc = {0, 0, -1, 1};
    static int[][] fishDist;
    static int[][] homeDist;
    static int ANS = Integer.MAX_VALUE;

    static class Node{
        int x;
        int y;
        int t;

        Node(int x, int y, int t){
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        fishDist = new int[N][M];
        homeDist = new int[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }
                else if(arr[i][j] == 'H'){
                    homeX = i;
                    homeY = j;
                }

            }
        }

        BFS(startX, startY, 'F');
        BFS(homeX, homeY, 'H');

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 'F'){
                    if(fishDist[i][j] == 0 || homeDist[i][j] == 0)
                        continue;

                    if(ANS > fishDist[i][j] + homeDist[i][j])
                        ANS = fishDist[i][j] + homeDist[i][j];
                }
            }
        }

        if(ANS == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ANS);
    }

    public static void BFS(int sX, int sY, char c){

        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[N][M];

        queue.add(new Node(sX, sY, 0));
        visited[sX][sY] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(c == 'F'){
                fishDist[node.x][node.y] = node.t;
            }
            else{
                homeDist[node.x][node.y] = node.t;
            }

            for(int p=0; p<4; p++){
                int nx = node.x + nr[p];
                int ny = node.y + nc[p];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]){
                    continue;
                }

                if(arr[nx][ny] == 'D')
                    continue;

                queue.add(new Node(nx, ny, node.t + 1));
                visited[nx][ny] = true;
            }
        }
    }
}