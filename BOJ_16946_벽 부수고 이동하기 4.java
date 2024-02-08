import java.io.*;
import java.util.*;

public class Main{

    static int N, M;
    static int[][] arr;
    static int[][] label;
    static boolean[][] visited;
    static boolean[] labelVisited;
    static int[][] ans;
    static int LABEL = 0;
    static int[] nr = {0, 0, -1, 1};
    static int[] nc = {-1, 1, 0, 0};
    static HashMap<Integer, Integer> map;

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
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        label = new int[N][M];
        visited = new boolean[N][M];
        map = new HashMap<>();
        ans = new int[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        map.put(0, 0);

        // 0 라벨링
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0 && !visited[i][j]){
                    LABEL += 1;
                    int cnt = BFS(i, j);

                    map.put(LABEL, cnt);
                }
            }
        }

        // 1 찾아서 사방탐색
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){

                if(arr[i][j] == 0)
                    continue;

                labelVisited = new boolean[LABEL+1];

                int tmpSum = 1;

                for(int p=0; p<4; p++){
                    int nextI = i + nr[p];
                    int nextJ = j + nc[p];

                    if(nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= M)
                        continue;

                    if(labelVisited[label[nextI][nextJ]])
                        continue;

                    tmpSum += map.get(label[nextI][nextJ]);
                    labelVisited[label[nextI][nextJ]] = true;
                }
                ans[i][j] = tmpSum % 10;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(ans[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    
    static int BFS(int i, int j){
        int cnt = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(i, j));
        visited[i][j] = true;
        label[i][j] = LABEL;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int nowX = node.x;
            int nowY = node.y;

            for(int p=0; p<4; p++){
                int nextX = nowX + nr[p];
                int nextY = nowY + nc[p];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || visited[nextX][nextY] || arr[nextX][nextY] == 1)
                    continue;

                visited[nextX][nextY] = true;
                label[nextX][nextY] = LABEL;
                queue.add(new Node(nextX, nextY));
                cnt += 1;
            }
        }

        return cnt;
    }
}