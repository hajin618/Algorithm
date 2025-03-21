import java.io.*;
import java.util.*;

// BOJ 24479
public class Main {
    static int N, M, R;
    static List<Integer> list[];
    static boolean[] visited;
    static int[] ANS;
    static int idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        ANS = new int[N+1];
        visited = new boolean[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
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

        DFS(R);

        for(int i=1; i<=N; i++){
            sb.append(ANS[i]).append("\n");
        }

        System.out.print(sb);
    }

    public static void DFS(int start){
        visited[start] = true;
        ANS[start] = idx++;
        for(int next : list[start]){
            if(!visited[next]){
                DFS(next);
            }
        }
    }

}