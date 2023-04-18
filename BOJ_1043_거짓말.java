import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static int N, M;
    static boolean[] knowTruth;
    static int[] parent;
    static List<Integer>[] party;
    static int ANS = 0;
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        knowTruth = new boolean[N+1];
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
        party = new ArrayList[M];
        for(int i=0; i<M; i++){
            party[i] = new ArrayList<>();
        }

        // 진실을 아는 사람의 수와 번호
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            int t = Integer.parseInt(st.nextToken());
            knowTruth[t] = true;
        }

        // 오는 사람의 수와 번호
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            party[i].add(f);

            for(int j=0; j<n-1; j++){
                int t = Integer.parseInt(st.nextToken());
                party[i].add(t);
                union(f, t);
            }
        }

//        for(int i=1; i<=N; i++){
//            System.out.print(parent[i] + " ");
//        }

        // 1~N 까지 knowTruth == true 이면 부모노드 true로
        for(int i=1; i<=N; i++){
            if(knowTruth[i]){
                knowTruth[find(i)] = true;
            }
        }

        // True 인 부모노드 가지고 있는 모든 노드들 true로
        for(int i=1; i<=N; i++){
            if(knowTruth[i]){
                for(int j=1; j<=N; j++){
                    if(parent[j] == i)
                        knowTruth[j] = true;
                }
            }
        }

        for(int i=0; i<M; i++){
            boolean flag = false;
            for(int a : party[i]){
                // 거짓말을 할 수 없는 파티 (진실을 아는 사람 || 아는사람과 파티 함께 한 사람)
                if(knowTruth[a]){
                    flag = true;
                    break;
                }
            }

            // 한 명도 없으면 ANS += 1;
            if(!flag)
                ANS += 1;
        }

        System.out.println(ANS);

    }
}