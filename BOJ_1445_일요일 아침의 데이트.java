import java.io.*;
import java.util.*;

public class Main{
    static int N, M, endI, endJ;
    static char[][] arr;
    static boolean[][] visited;
    static int[] nr = {0, 0, -1, 1};
    static int[] nc = {-1, 1, 0, 0};

    static class Node implements Comparable<Node>{
        int i;
        int j;
        int g;
        int n;

        Node(int i, int j, int g, int n){
            this.i = i;
            this.j = j;
            this.g = g;
            this.n = n;
        }

        @Override
        public int compareTo(Node o){
            if(o.g == this.g){
                return this.n - o.n;
            }

            return this.g - o.g;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'S'){
                    pq.add(new Node(i, j, 0, 0));
                    visited[i][j] = true;
                }
                else if(arr[i][j] == 'F'){
                    endI = i;
                    endJ = j;
                }
            }
        }

        // g 주변 표시하기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 'g'){
                    for(int p=0; p<4; p++){
                        int nearI = i + nr[p];
                        int nearJ = j + nc[p];
                        if(nearI >= 0 && nearI < N && nearJ >=0 && nearJ < M && arr[nearI][nearJ] == '.')
                            arr[nearI][nearJ] = 'n';
                    }
                }
            }
        }

        while(!pq.isEmpty()){
            Node now = pq.poll();
            boolean flag = false;

            for(int p=0; p<4; p++){
                int nextI = now.i + nr[p];
                int nextJ = now.j + nc[p];

                if(nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= M || visited[nextI][nextJ]){
                    continue;
                }

                visited[nextI][nextJ] = true;

                if(arr[nextI][nextJ] == '.'){
                    pq.add(new Node(nextI, nextJ, now.g, now.n));
                }
                else if(arr[nextI][nextJ] == 'g'){
                    pq.add(new Node(nextI, nextJ, now.g + 1, now.n));
                }
                else if(arr[nextI][nextJ] == 'n'){
                    pq.add(new Node(nextI, nextJ, now.g, now.n + 1));
                }
                else if(arr[nextI][nextJ] == 'F'){
                    sb.append(now.g).append(" ").append(now.n);
                    flag = true;
                    break;
                }
            }

            if(flag)
                break;
        }

        System.out.println(sb);
    }
}