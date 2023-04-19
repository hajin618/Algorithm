import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    static List<Node> list;
    static class Node implements Comparable<Node>{
        int node1;
        int node2;
        int dist;
        Node(int node1, int node2, int dist){
            this.node1 = node1;
            this.node2 = node2;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return o.dist - this.dist;
        }
    }

    public static int find(int a){
        if(parent[a] == a)
            return a;
        else{
            return parent[a] = find(parent[a]);
        }
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            if(pa < pb){
                parent[pb] = parent[pa];
            }
            else
                parent[pa] = parent[pb];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        int sumAll = 0;
        int maxDist = 0;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
            if(d == 1){
                union(a, b);
                maxDist += c;
            }
            sumAll += c;
        }

        Collections.sort(list);
        
        for(Node node : list){
            if(find(node.node1) != find(node.node2)){
                union(node.node1, node.node2);
                maxDist += node.dist;
            }
        }

        System.out.println(sumAll - maxDist);
    }
}