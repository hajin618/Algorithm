import java.io.*;
import java.util.*;

public class Main {

    static int N, M, start, end, ans;
    static List<Node> list;
    static int[] parent;

    static class Node implements Comparable<Node>{
        int from;
        int to;
        int w;

        Node(int from, int to, int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }

        @Override
        public int compareTo(Node o){
            return o.w - this.w;
        }
    }

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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        list = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Collections.sort(list);

        for(Node now : list){
            union(now.from, now.to);

            if(find(start) == find(end)){
                System.out.println(now.w);

                break;
            }
        }
    }
}