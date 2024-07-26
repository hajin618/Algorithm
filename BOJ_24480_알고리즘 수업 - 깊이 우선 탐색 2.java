import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[] ANS;
    static List<Integer>[] list;
    static boolean[] visited;
    static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        ANS = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=N; i++){
            Collections.sort(list[i], Collections.reverseOrder());
        }

        visited[R] = true;
        DFS(R);

        for(int i=1; i<=N; i++){
            sb.append(ANS[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int now){
        ANS[now] = idx;
        idx += 1;
        for(int next : list[now]){
            if(!visited[next]){
                visited[next] = true;
                DFS(next);
            }
        }
    }
}