import java.io.*;
import java.util.*;

public class Main{
    static int T, N, M, K;
    static List<Node>[] list;
    static boolean[] visited;
    static int[][] dist;
    static int[] ANS;
    static boolean[] exists;

    static class Node implements Comparable<Node>{
        int node;
        int dist;

        Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++){

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N+1];
            for(int i=0; i<=N; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list[a].add(new Node(b, c));
                list[b].add(new Node(a, c));
            }
            exists = new boolean[N+1];
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                exists[Integer.parseInt(st.nextToken())] = true;
            }

            dist = new int[N+1][N+1];

            // 1번 방부터 N번 방까지 Dijkstra
            for(int i=1; i<=N; i++){
                visited = new boolean[N+1];
                Dijkstra(i);
            }

            int min = Integer.MAX_VALUE;
            int min_idx = 0;
            ANS = new int[N+1];

            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(exists[j])
                        ANS[i] += dist[j][i];
                }
            }

            for(int i=1; i<=N; i++){
                if(min > ANS[i]){
                    min_idx = i;
                    min = ANS[i];
                }
            }
            sb.append(min_idx).append("\n");
        }
        System.out.println(sb);

    }

    public static void Dijkstra(int start){
        for(int i=0; i<=N; i++){
            dist[start][i] = Integer.MAX_VALUE;
        }
        dist[start][start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(!visited[now.node]){
                visited[now.node] = true;

                for(Node next : list[now.node]){
                    if(dist[start][next.node] > dist[start][now.node] + next.dist){
                        dist[start][next.node] = dist[start][now.node] + next.dist;
                        pq.add(new Node(next.node, dist[start][next.node]));
                    }
                }
            }
        }
    }
}