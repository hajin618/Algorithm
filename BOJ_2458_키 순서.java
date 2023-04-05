import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    public static int N, M;    // N:학생수    // M:비교 횟수
    public static List<Integer>[] BIG;
    public static List<Integer>[] SMALL;
    public static boolean[] visited;
    public static int ANS;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BIG = new ArrayList[N+1];
        SMALL = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            BIG[i] = new ArrayList<>();
            SMALL[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            BIG[a].add(b);
            SMALL[b].add(a);
        }

        for(int i=1; i<=N; i++) {

            visited = new boolean[N+1];
            bfs(BIG, i);
            bfs(SMALL, i);

            boolean flag = true;
            for(int j=1; j<=N; j++) {
                if(!visited[j]) {
                    flag = false;
                    break;
                }
            }

            if(flag)
                ANS += 1;
        }

        System.out.println(ANS);
        
    }
    
    public static void bfs(List<Integer>[] list, int start) {
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int next = queue.poll();
            visited[next] = true;
            
            for(int i=0; i<list[next].size(); i++) {
                if(!visited[list[next].get(i)]) {
                    visited[list[next].get(i)] = true;
                    queue.add(list[next].get(i));
                }
            }
        }
    }
    
}