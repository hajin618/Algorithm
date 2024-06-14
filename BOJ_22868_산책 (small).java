import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, E, ANS;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] route;

    static class Node{
        int num;
        int cnt;

        public Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        route = new int[N+1];
        list = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N ; i++) {
            Collections.sort(list[i]);
        }

        bfs(S, E);

        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }
        int last = route[E];
        while(last > 0){
            visited[last] = true;
            last = route[last];
        }

        bfs(E, S);

        System.out.println(ANS);
    }

    static void bfs(int start, int end){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(start, 0));
        visited[start] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int now : list[node.num]){
                if(!visited[now]){
                    visited[now] = true;
                    route[now] = node.num;
                    queue.add(new Node(now, node.cnt + 1));
                }

                if(now == end){
                    ANS += node.cnt + 1;
                    return;
                }
            }
        }
    }
}