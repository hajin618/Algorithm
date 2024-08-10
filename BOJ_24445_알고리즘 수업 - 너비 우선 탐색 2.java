import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static List<Integer>[] list;
    static boolean[] visited;
    static int idx = 1;
    static int[] ANS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        ANS = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        int a, b;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(list[i], Collections.reverseOrder());
        }
        BFS();
        for(int i=1; i<=N; i++){
            sb.append(ANS[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        visited[R] = true;
        ANS[R] = idx;
        idx += 1;

        queue.add(R);

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int next : list[now]){
                if(!visited[next]){
                    queue.add(next);
                    visited[next] = true;
                    ANS[next] = idx;
                    idx += 1;
                }
            }
        }
    }
}