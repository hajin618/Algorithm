import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    // 정점 p개, 간선 w개, 출발 c, 도착 v
    static int P, W, C, V;
    static List<Node>[] list;
    static boolean[] visited;
    static int MIN = Integer.MAX_VALUE;
    static class Node implements Comparable<Node>{
        int node;
        int width;
        Node(int node, int width){
            this.node = node;
            this.width = width;
        }

        @Override
        public int compareTo(Node o){
            return o.width - this.width;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[P];
        list = new ArrayList[P];
        for(int i=0; i<P; i++)
            list[i] =  new ArrayList<>();

        for(int i=0; i<W; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(C, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(MIN > now.width && now.node != C)
                MIN = now.width;

            if(now.node == V)
                break;
            
            visited[now.node] = true;

            for(Node next : list[now.node]){
                if(!visited[next.node])
                    pq.add(next);
            }
        }
        System.out.println(MIN);
    }
}