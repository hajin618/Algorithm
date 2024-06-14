import java.io.*;
import java.util.*;

public class Main {
    static int G, P, ANS;
    static int[] parent;

    static int find(int a){
        if(parent[a] == a)
            return a;
        else
            return parent[a] = find(parent[a]);
    }

    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            if(pa < pb)
                parent[pb] = pa;
            else
                parent[pa] = pb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        parent = new int[G+1];
        for(int i=1; i<G+1; i++){
            parent[i] = i;
        }

        for(int i=0; i<P; i++){
            int a = Integer.parseInt(br.readLine());
            if(find(a) == 0)
                break;
            union(find(a), find(a)-1);
            ANS += 1;
        }

        System.out.println(ANS);
    }
}