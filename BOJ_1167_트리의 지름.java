import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    public static StringBuilder sb;
    public static int V;
    public static List<Node>[] list;
    public static boolean[] visited;
    public static int MAX = Integer.MIN_VALUE;
    public static int LAST;

    public static class Node{
        int num;
        int dist;
        Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            while(true){
                int a = Integer.parseInt(st.nextToken());
                if(a == -1)
                    break;
                int b = Integer.parseInt(st.nextToken());

                list[num].add(new Node(a, b));
            }
        }

        visited = new boolean[V+1];

        dfs(1, 0);
        visited = new boolean[V+1];
        dfs(LAST, 0);

        System.out.println(MAX);

    }

    public static void dfs(int node, int sum){

        if(sum > MAX){
            MAX = sum;
            LAST = node;
        }

        visited[node] = true;

        for(Node next : list[node]){
            if(!visited[next.num]){
                visited[next.num] = true;
                dfs(next.num, sum + next.dist);
                visited[next.num] = false;
            }
        }
    }

}