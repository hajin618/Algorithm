import java.io.*;
import java.util.*;

public class Main {

    static int N, a, b;
    static int[] arr;
    static class Node{
        int num;
        int cnt;

        Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        System.out.println(BFS());
    }

    static int BFS(){
        boolean[] visited = new boolean[N+1];
        visited[a] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 0));

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.num == b){
                return now.cnt;
            }

            for(int i=now.num; i >= 1; i -= arr[now.num]){
                if(visited[i])
                    continue;
                visited[i] = true;
                queue.add(new Node(i, now.cnt + 1));
            }
            for(int i=now.num; i <= N; i += arr[now.num]){
                if(visited[i])
                    continue;
                visited[i] = true;
                queue.add(new Node(i, now.cnt + 1));
            }
        }

        return -1;
    }
}