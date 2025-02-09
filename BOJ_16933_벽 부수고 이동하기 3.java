import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static char[][] arr;
    static boolean[][][] visited;
    static int[] nr = {-1, 1, 0, 0};
    static int[] nc = {0, 0, -1, 1};

    public static class Node{
        int i;
        int j;
        int breakCnt;
        int moveCnt;
        boolean day;
        Node(int i, int j, int breakCnt, int moveCnt, boolean day){
            this.i = i;
            this.j = j;
            this.breakCnt = breakCnt;
            this.moveCnt = moveCnt;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M][K+1];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        BFS();
    }

    public static void BFS(){
        visited[0][0][0] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 1, true));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int ii = node.i;
            int jj = node.j;
            int nbc = node.breakCnt;
            int nmc = node.moveCnt;
            boolean ndy = node.day;

            if(ii == N-1 && jj == M-1){
                System.out.println(nmc);
                return;
            }

            for(int p=0; p<4; p++){
                int iii = ii + nr[p];
                int jjj = jj + nc[p];

                if(iii>=0 && iii<N && jjj>=0 && jjj<M){
                    if(arr[iii][jjj] == '0'){
                        if(!visited[iii][jjj][nbc]) {
                            queue.add(new Node(iii, jjj, nbc, nmc + 1, !ndy));
                            visited[iii][jjj][nbc] = true;
                        }
                    }
                    // 벽
                    else{
                        // breakCnt < K && 낮
                        if(nbc+1<=K && ndy){
                            if(!visited[iii][jjj][nbc+1]) {
                                queue.add(new Node(iii, jjj, nbc + 1, nmc + 1, !ndy));
                                visited[iii][jjj][nbc + 1] = true;
                            }
                        }
                        // breakCnt < K && 밤
                        else if(nbc+1<=K && !ndy){
                            queue.add(new Node(ii, jj, nbc, nmc+1, !ndy));
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}