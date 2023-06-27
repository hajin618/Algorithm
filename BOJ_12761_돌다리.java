import java.io.*;
import java.util.*;

public class Main {

    static int A, B, N, M;
    static boolean[] visited;
    static Queue<Node> queue;

    static class Node{
        int num;
        int cnt;

        Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        System.out.println(BFS());

    }

    public static int BFS(){
        queue = new LinkedList<>();

        queue.add(new Node(N, 0));
        visited[N] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.num == M){
                return now.cnt;
            }

            int next = now.num + 1;
            check(next, now.cnt + 1);

            next = now.num - 1;
            check(next, now.cnt + 1);

            next = now.num + A;
            check(next, now.cnt + 1);

            next = now.num - A;
            check(next, now.cnt + 1);

            next = now.num + B;
            check(next, now.cnt + 1);

            next = now.num - B;
            check(next, now.cnt + 1);

            next = now.num * A;
            check(next, now.cnt + 1);

            next = now.num * B;
            check(next, now.cnt + 1);

        }

        return 0;
    }

    public static void check(int next, int cnt){
        if(next >= 0 && next <= 100000 && !visited[next]){
            queue.add(new Node(next, cnt));
            visited[next] = true;
        }

    }
}