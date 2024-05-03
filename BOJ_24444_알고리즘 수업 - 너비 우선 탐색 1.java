import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        ans = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(list[i]);
        }

        BFS();

        for(int i=1; i<=N; i++){
            sb.append(ans[i]).append("\n");
        }

        System.out.print(sb);
    }

    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(R);
        visited[R] = true;
        int order = 1;
        ans[R] = order;
        order += 1;

        while(!queue.isEmpty()){
            int now = queue.poll();


            int size = list[now].size();
            for(int i=0; i<size; i++){
                int next = list[now].get(i);

                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                    ans[next] = order;
                    order += 1;
                }
            }
        }
    }
}