import java.io.*;
import java.util.*;

public class Main {

    static int T, N, node1, node2;
    static int[] parent;
    static boolean[] route;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            route = new boolean[N+1];

            for(int i=0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());

            NODE1(node1);
            System.out.println(NODE2(node2));

        }
    }

    public static void NODE1(int now){
        if(now == 0)
            return;

        route[now] = true;
        NODE1(parent[now]);
    }

    public static int NODE2(int now){
        if(route[now])
            return now;
        else{
            return NODE2(parent[now]);
        }

    }
}