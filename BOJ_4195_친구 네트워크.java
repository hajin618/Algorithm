import java.io.*;
import java.util.*;

public class Main {

    static int[] parent, cnt;
    static int test_case, F, idx;
    static Map<String, Integer> map;

    static int find(int a){
        if(parent[a] == a)
            return a;
        else{
            return parent[a] = find(parent[a]);
        }
    }

    static int union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa != pb){
            if(pa < pb){
                parent[pb] = parent[pa];
                return cnt[pa] = cnt[pa] + cnt[pb];
            }
            else{
                parent[pa] = parent[pb];
                return cnt[pb] = cnt[pb] + cnt[pa];
            }
        }

        return cnt[pa];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        test_case = Integer.parseInt(br.readLine());

        for(int i=0; i<test_case; i++){
            map = new HashMap<>();
            F = Integer.parseInt(br.readLine());

            parent = new int[200001];
            cnt = new int[200001];

            for(int j=0; j<200001; j++){
                parent[j] = j;
                cnt[j] = 1;
            }
            
            idx = 1;
            for(int j=0; j<F; j++){
                st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                if(!map.containsKey(name1)){
                    map.put(name1, idx);
                    idx += 1;
                }
                if(!map.containsKey(name2)){
                    map.put(name2, idx);
                    idx+= 1;
                }

                int idx1 = map.get(name1);
                int idx2 = map.get(name2);
                int ans = union(idx1, idx2);
                sb.append(ans).append("\n");
            }
        }

        System.out.print(sb);
    }
}