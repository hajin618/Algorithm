import java.util.*;
import java.io.*;

public class Main {

    static int N, D;
    static int[] dist;
    static List<Node>[] list;

    static class Node{
        int node;
        int dist;
        Node(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[D+1];
        for(int i=0; i<=D; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        list = new ArrayList[D+1];
        for(int i=0; i<=D; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(b <= D && b-a > c){
                list[b].add(new Node(a, c));
            }
        }

        dist[0] = 0;
        for(int i=1; i<=D; i++){
            // 지름길 존재하면
            if(list[i].size() > 0){
                for(Node node : list[i]){
                    if(dist[i] > dist[node.node] + node.dist){
                        dist[i] = Math.min(dist[i - 1] + 1, dist[node.node] + node.dist);
                    }
                }
            }
            else{
                dist[i] = dist[i - 1] + 1;
            }
        }

        System.out.println(dist[D]);
    }
}