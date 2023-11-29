import java.io.*;
import java.util.*;

public class Main {
    static int x1, y1, x2, y2, N;
    static boolean[] isPrime;
    static List<Node>[] list;
    static int[] dist;

    static class Node implements Comparable<Node>{
        int y;
        int dist;
        Node(int y, int dist){
            this.y = y;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }

    public static int getDist(int x1, int y1, int x2, int y2){
        return (int)Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        isPrime = new boolean[12001];

        for(int i=2; i<isPrime.length; i++){
            if(isPrime[i])
                continue;

            for(int j=i+i; j<=12000; j+=i){
                isPrime[j] = true;
            }

        }
        isPrime[0] = true;
        isPrime[1] = true;

        List<Node> tmpList = new ArrayList<>();
        tmpList.add(new Node(x1, y1));
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tmpList.add(new Node(x, y));
        }
        tmpList.add(new Node(x2, y2));

        list = new ArrayList[N+2];
        for(int i=0; i<N+2; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<tmpList.size(); i++){
            for(int j=i+1; j<tmpList.size(); j++){
                int dist = getDist(tmpList.get(i).y, tmpList.get(i).dist, tmpList.get(j).y, tmpList.get(j).dist);
                if(!isPrime[dist]){
                    list[i].add(new Node(j, dist));
                    list[j].add(new Node(i, dist));
                }
            }
        }

        dist = new int[N+2];
        for(int i=0; i<dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(now.dist > dist[now.y]){
                continue;
            }

            for(int i=0; i<list[now.y].size(); i++){
                int nextY = list[now.y].get(i).y;
                int nextDist = list[now.y].get(i).dist;

                if(dist[nextY] > dist[now.y] + nextDist){
                    dist[nextY] = dist[now.y] + nextDist;
                    pq.add(new Node(nextY, dist[nextY]));
                }
            }
        }

        System.out.println(dist[N+1] == Integer.MAX_VALUE? -1 : dist[N+1]);
    }
}