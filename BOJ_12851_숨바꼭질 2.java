import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] visited;
    static int CNT, ANS;

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
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[100001];
        CNT = 0;

        BFS(N);

        System.out.println(ANS);
        System.out.println(CNT);
    }

    public static void BFS(int START){
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(START, 0));
        visited[N] = 1;

        while(!queue.isEmpty()){
            Node now = queue.poll();

            if(now.num == K){
                if(CNT == 0){
                    ANS = now.cnt;
                }
                if(ANS == now.cnt){
                    CNT += 1;
                }
                continue;
            }

            for(int i=0; i<3; i++){
                int nextNum = 0;
                if(i == 0)
                    nextNum = now.num - 1;
                else if(i == 1)
                    nextNum = now.num + 1;
                else
                    nextNum = now.num * 2;

                if(nextNum >= 0 && nextNum <= 100000 && (visited[nextNum] == 0 || visited[nextNum] == now.cnt + 1)){
                    visited[nextNum] = now.cnt + 1;
                    queue.add(new Node(nextNum, now.cnt + 1));
                }
            }

        }


    }
}