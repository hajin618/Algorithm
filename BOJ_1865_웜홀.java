import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static int T, N, M, W;
    static List<EDGE> list;
    static int[] dist;
    static boolean flag;
    static class EDGE{
        int from;
        int to;
        int dist;

        EDGE(int from, int to, int dist){
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                list.add(new EDGE(from, to, dist));
                list.add(new EDGE(to, from, dist));
            }

            for(int i=0; i<W; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());

                list.add(new EDGE(from, to, -dist));
            }

            flag = false;

            for(int i=1; i<=N; i++){
                // 음수 사이클 존재하면 true;
                flag = func(i);

                if(flag)
                    break;
            }

            if(flag)
                System.out.println("YES");
            else System.out.println("NO");

        }

    }
    public static boolean func(int start){
        dist = new int[N+1];

        for(int i=0; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;
        boolean update = false;

        for(int i=1; i<=N; i++){
            update = false;
            for(EDGE edge : list){
                if(dist[edge.from] != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.dist){
                    dist[edge.to] = dist[edge.from] + edge.dist;
                    update = true;
                }
            }
            if(!update)
                break;
        }

        if(dist[start]<0)
            return true;
        else return false;
    }
}