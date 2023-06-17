import java.io.*;
import java.util.*;

public class Main {

    static int T, N, K, M;
    static int[] parent;

    public static int find(int a){
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            if(pa < pb)
                parent[pb] = pa;
            else
                parent[pa] = pb;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            sb = new StringBuilder();

            N = Integer.parseInt(br.readLine());    // 유저 수
            K = Integer.parseInt(br.readLine());    // 친구 관계 수

            parent = new int[N];
            for(int i=0; i<N; i++){
                parent[i] = i;
            }

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            M = Integer.parseInt(br.readLine());

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(find(a) == find(b))
                    sb.append("1").append("\n");
                else
                    sb.append("0").append("\n");
            }

            System.out.println("Scenario " + test_case + ":");
            System.out.println(sb);

        }

    }
}