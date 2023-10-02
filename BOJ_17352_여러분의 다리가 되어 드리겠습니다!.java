import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] parent;

    static int find(int a){
        if(parent[a] == a){
            return a;
        }
        else
            return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            if(pa < pb)
                parent[pb] = parent[pa];
            else
                parent[pa] = parent[pb];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        for(int i=0; i<N-2; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }
        boolean flag = false;
        for(int i=1; i<=N; i++){
            if(flag)
                break;
            for(int j=i+1; j<=N; j++){
                if(find(i) != find(j)){
                    System.out.println(i+" "+j);
                    flag = true;
                    break;
                }
            }
        }
    }
}