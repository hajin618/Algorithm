import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long ANS;
    static List<Node>[] list;
    static boolean[] visited;
    static long[] d;

    static class Node{
        int node;
        int dist;

        Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        d = new long[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        int a, b, c;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(Node next : list[now]){
                int n = next.node;
                if(visited[n])
                    continue;
                d[n] = d[now] + next.dist;


                queue.add(n);
                visited[n] = true;
            }
        }
        for(int i=1; i<=N; i++){
            if(ANS < d[i])
                ANS = d[i];
        }
        System.out.println(ANS);
    }
}