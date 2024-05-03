import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] parent;
    static List<Integer>[] friend;
    static List<Integer>[] enemy;
    static Set<Integer> set;

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
                parent[pb] = parent[pa];
            else
                parent[pa] = parent[pb];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        friend = new ArrayList[N+1];
        enemy = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
            friend[i] = new ArrayList<>();
            enemy[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if(c == 'F'){
                friend[p].add(q);
                friend[q].add(p);
            }
            else{
                enemy[p].add(q);
                enemy[q].add(p);
            }
        }

        // 원수의 원수 찾기
        for(int i=1; i<=N; i++){
            int size1 = enemy[i].size();

            for(int j=0; j<size1; j++){
                int en = enemy[i].get(j);
                int size2 = enemy[en].size();

                for(int k=0; k<size2; k++){
                    int enen = enemy[en].get(k);
                    if(i == enen)
                        continue;

                    friend[i].add(enen);
                    friend[enen].add(i);
                }
            }
        }

        for(int i=1; i<=N; i++){
            int size = friend[i].size();
            for(int j=0; j<size; j++){
                union(i, friend[i].get(j));
            }
        }

        set = new HashSet<>();
        for(int i=1; i<=N; i++){
            set.add(parent[i]);
        }

        System.out.println(set.size());
    }
}