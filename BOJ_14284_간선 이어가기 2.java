import java.io.*;
import java.util.*;

public class Main{

    static int N, M;
    static List<Edge>[] list;
    static PriorityQueue<Edge> pq;
    static int[] dist;
    static boolean[] visited;
    static int S, T;

    static class Edge implements Comparable<Edge>{
        int node;
        int dist;

        Edge(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Edge o){
            return this.dist - o.dist;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        for(int i=0; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dist[S] = 0;

        Dijkstra();

        System.out.println(dist[T]);
    }

    static void Dijkstra(){

        pq = new PriorityQueue<>();
        pq.add(new Edge(S, 0));

        while(!pq.isEmpty()){
            Edge now = pq.poll();

            if(!visited[now.node]){
                visited[now.node] = true;

                for(Edge next : list[now.node]){
                    if(dist[next.node] > dist[now.node] + next.dist){
                        dist[next.node] = dist[now.node] + next.dist;
                        pq.add(new Edge(next.node, dist[next.node]));
                    }
                }
            }

        }
    }
}