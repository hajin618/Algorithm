import java.io.*;
import java.util.*;

public class Main{

    static int N, M;
    static char[][] arr;
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
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        parent = new int[N*M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
                parent[i*M + j] = i*M + j;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int nextI = i;
                int nextJ = j;

                if(arr[i][j] == 'U')
                    nextI--;
                else if(arr[i][j] == 'D')
                    nextI++;
                else if(arr[i][j] == 'R')
                    nextJ++;
                else
                    nextJ--;

                union(i*M + j, nextI*M + nextJ);
            }
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                set.add(find(i*M + j));
            }
        }

        System.out.println(set.size());
    }
}