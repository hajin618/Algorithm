package SSAFY;
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
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

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    union(i, j);
                }
            }
        }

        boolean flag = true;

        st = new StringTokenizer(br.readLine());
        int p = parent[Integer.parseInt(st.nextToken())];
        for(int i=0; i<M-1; i++){
            if(p != parent[Integer.parseInt(st.nextToken())]){
                flag = false;
                break;
            }
        }



        if(flag)
            System.out.println("YES");
        else System.out.println("NO");

    }

}