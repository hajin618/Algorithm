import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static List<dNode>[] dList;
    static List<uNode> uList;
    static boolean[] visited;
    static int[] dist;
    static int[] parent;
    static int uANS, dANS, START;

    static class uNode implements Comparable<uNode>{
        int node1;
        int node2;
        int dist;

        uNode(int node1, int node2, int dist){
            this.node1 = node1;
            this.node2 = node2;
            this.dist = dist;
        }

        @Override
        public int compareTo(uNode o) {
            return this.dist - o.dist;
        }
    }

    static class dNode implements Comparable<dNode>{
        int node;
        int dist;

        dNode(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(dNode o) {
            return this.dist - o.dist;
        }

    }

    static int find(int a) {
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa != pb) {
            if(pa < pb)
                parent[pb] = find(pa);
            else
                parent[pa] = find(pb);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        uList = new ArrayList<>();
        dist = new int[N];
        for(int i=0; i<N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[N];
        parent = new int[N];
        for(int i=0; i<N; i++) {
            parent[i] = i;
        }
        dList = new ArrayList[N];
        for(int i=0; i<N; i++) {
            dList[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            uList.add(new uNode(a, b, c));
        }

        Collections.sort(uList);

        // mst
        for(uNode now : uList) {
            if(find(now.node1) != find(now.node2)) {
                union(now.node1, now.node2);
                dList[now.node1].add(new dNode(now.node2, now.dist));
                dList[now.node2].add(new dNode(now.node1, now.dist));
                uANS += now.dist;
            }
        }

        // dfs
        visited[0] = true;
        dfs(0, 0);

        visited = new boolean[N];
        visited[START] = true;
        dfs(START, 0);

        System.out.println(uANS);
        System.out.println(dANS);

    }

    static void dfs(int node, int sum){
        if(dANS < sum) {
            dANS = sum;
            START = node;
        }

        for(dNode next : dList[node]){
            if(!visited[next.node]){
                visited[next.node] = true;
                dfs(next.node, sum + next.dist);
                visited[next.node] = false;
            }
        }
    }
}