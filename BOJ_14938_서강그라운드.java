import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static int N, M, R;
    public static int[] item;
    public static List<Node>[] list;
    public static int[] dist;
    public static boolean[] visited;
    public static int ANS = Integer.MIN_VALUE;
    public static class Node implements Comparable<Node>{
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        item = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        for(int i=1; i<=N; i++){
            dist = new int[N+1];
            visited = new boolean[N+1];
            Dijkstra(i);
        }

        System.out.println(ANS);

    }

    public static void Dijkstra(int start){
        for(int i=0; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(!visited[now.node]){
                visited[now.node] = true;

                for(Node next : list[now.node]){
                    if(dist[next.node] > dist[now.node] + next.dist){
                        dist[next.node] = dist[now.node] + next.dist;
                        pq.add(new Node(next.node, dist[next.node]));
                    }
                }
            }
        }
        int sum = 0;
        for(int i=1; i<=N; i++){
            if(dist[i] <= M)
                sum += item[i];
        }

        if(sum > ANS){
            ANS = sum;
        }

    }
}