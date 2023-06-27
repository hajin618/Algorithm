import java.io.*;
import java.util.*;

public class Main {

    static int N, M, S, E;
    static List<Integer>[] con;
    static boolean[] visited;

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
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        con = new ArrayList[N + 1];
        for(int i=0; i<=N; i++){
            con[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            con[a].add(b);
            con[b].add(a);
        }

        System.out.println(BFS());
    }

    public static int BFS(){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(S, 0));
        visited[S] = true;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.num == E){
                return now.cnt;
            }

            int next = now.num + 1;
            if(next > 0 && next <= N && !visited[next]){
                queue.add(new Node(next, now.cnt + 1));
                visited[next] = true;
            }

            next = now.num - 1;
            if(next > 0 && next <= N && !visited[next]){
                queue.add(new Node(next, now.cnt + 1));
                visited[next] = true;
            }

            if(con[now.num].size() != 0){
                for(int p=0; p<con[now.num].size(); p++){
                    next = con[now.num].get(p);
                    if(next > 0 && next <= N && !visited[next]){
                        queue.add(new Node(next, now.cnt + 1));
                        visited[next] = true;
                    }
                }
            }
        }

        return 0;
    }

}