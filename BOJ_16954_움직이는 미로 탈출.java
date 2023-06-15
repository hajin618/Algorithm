import java.io.*;
import java.util.*;
public class Main {

    static char[][] map;
    static boolean[][][] visited;
    static boolean success = false;
    static int[] nr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] nc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new char[8][8];
        visited = new boolean[8][8][10];

        for(int i=0; i<8; i++){
            String s = br.readLine();
            for(int j=0; j<8; j++){
                map[i][j] = s.charAt(j);
            }
        }

        bfs();

        if(success == true)
            System.out.println(1);
        else
            System.out.println(0);
    }

    public static void bfs(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(7, 0, 0));
        visited[7][0][0] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.x == 0 && now.y == 7){
                success = true;
                break;
            }

            if(now.cnt >= 8){
                success = true;
                break;
            }

            for(int p=0; p<9; p++){
                int nextX = now.x + nr[p];
                int nextY = now.y + nc[p];

                if(nextX<0 || nextX>=8 || nextY<0 || nextY>=8 || visited[nextX][nextY][now.cnt+1])
                    continue;

                if(nextX - now.cnt >= 0 && map[nextX - now.cnt][nextY] == '#')
                    continue;
                
                // 벽 내려올 예정
                if(nextX - now.cnt - 1 >=0 && map[nextX - now.cnt - 1][nextY] == '#')
                    continue;

                queue.add(new Node(nextX, nextY, now.cnt + 1));
                visited[nextX][nextY][now.cnt+1] = true;
            }
        }
    }
}