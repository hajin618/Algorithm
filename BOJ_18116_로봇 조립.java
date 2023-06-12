package SSAFY;
import java.io.*;
import java.util.*;
public class Main {
    static final int n = 1000001;

    static int N;
    static int[] parent;
    static int[] cnt;

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
            if(pa < pb){
                parent[pb] = pa;
                cnt[pa] += cnt[pb];
            }
            else{
                parent[pa] = pb;
                cnt[pb] += cnt[pa];
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        parent = new int[n];
        cnt = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            cnt[i] = 1;
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);

            // union
            if(c == 'I'){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);

            }
            else{
                int a = Integer.parseInt(st.nextToken());

                sb.append(cnt[find(a)]).append("\n");
            }

        }
        System.out.println(sb);
    }
}