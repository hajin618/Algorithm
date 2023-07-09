import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ANS;
    static char[][] arr;
    static int[] nr = {-1, 1, 0, 0};
    static int[] nc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int startX, startY;
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'I'){
                    startX = i;
                    startY = j;
                }
            }
        }
        BFS();
        if(ANS == 0)
            System.out.println("TT");
        else
            System.out.println(ANS);
    }

    public static void BFS(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(arr[now.x][now.y] == 'P')
                ANS += 1;

            for(int p=0; p<4; p++){
                int nextX = now.x + nr[p];
                int nextY = now.y + nc[p];

                if(nextX<0 || nextX>=N || nextY<0 || nextY>=M || visited[nextX][nextY] || arr[nextX][nextY]=='X')
                    continue;

                queue.add(new Node(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }

}