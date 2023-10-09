import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] visited;
    static int ANS = Integer.MAX_VALUE;
    static class Node implements Comparable<Node>{
        int node;
        int time;
        int term;

        Node(int node, int time, int term){
            this.node = node;
            this.time = time;
            this.term = term;
        }

        @Override
        public int compareTo(Node o){
            return this.time - o.time;
        }
    }
    static List<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        for(int i=0; i<=N; i++){
            visited[i] = Integer.MAX_VALUE;
        }
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, T, W));
        }

        Dijkstra();

        System.out.println(visited[N]);
    }

    public static void Dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 0, 0));
        visited[1] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            for(Node next : list[now.node]){
                int tmp = now.time;
                if(now.time % next.term != 0)
                    tmp = now.time + next.term - (now.time % next.term);

                if(visited[next.node] > next.time + tmp){
                    visited[next.node] = next.time + tmp;
                    pq.add(new Node(next.node, visited[next.node], next.term));
                }
            }
        }
    }
}