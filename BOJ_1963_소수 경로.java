import java.io.*;
import java.util.*;
public class Main {
    static int t;
    static int start, end;
    static int[] visited;
    static int ANS;
    static class Node{
        int num;
        int cnt;

        Node(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
    static boolean[] isPrime;   // 소수 : false
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        isPrime = new boolean[10000];

        t = Integer.parseInt(br.readLine());

        // 소수 구하기
        for(int i=2; i<=9999; i++){
            int now = i + i;
            while(true){
                if(now > 9999)
                    break;

                isPrime[now] = true;
                now += i;
            }
        }

        for(int test_case=1; test_case <= t; test_case++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            visited = new int[10000];
            ANS = Integer.MAX_VALUE;

            bfs(start, end);

            if(ANS == Integer.MAX_VALUE)
                System.out.println("Impossible");
            else
                System.out.println(ANS);

        }
    }

    static void bfs(int s, int e){

        Queue<Node> queue = new LinkedList<>();
        // 방문배열 0이 아닌 곳만 방문하기 위해 1부터 시작
        // 정답 나오면 1 빼기
        queue.add(new Node(s, 1));
        visited[s] = 1;

        while(!queue.isEmpty()){

            Node now = queue.poll();

            if(now.num == e){
                ANS = now.cnt - 1;
                break;
            }

            String str = Integer.toString(now.num);

            // 첫번째 자리 바꾸기
            for(int i=1; i<=9; i++){
                String nextStr = Integer.toString(i) + str.substring(1, 4);
                int nextInt = Integer.parseInt(nextStr);

                if(!isPrime[nextInt] && visited[nextInt] == 0){
                    queue.add(new Node(nextInt, now.cnt + 1));
                    visited[nextInt] = now.cnt + 1;
                }
            }

            // 두번째 자리 바꾸기
            for(int i=0; i<=9; i++){
                String nextStr = str.substring(0, 1) + Integer.toString(i) + str.substring(2, 4);
                int nextInt = Integer.parseInt(nextStr);

                if(!isPrime[nextInt] && visited[nextInt] == 0){
                    queue.add(new Node(nextInt, now.cnt + 1));
                    visited[nextInt] = now.cnt + 1;
                }
            }

            // 세번째 자리 바꾸기
            for(int i=0; i<=9; i++){
                String nextStr = str.substring(0, 2) + Integer.toString(i) + str.substring(3, 4);
                int nextInt = Integer.parseInt(nextStr);

                if(!isPrime[nextInt] && visited[nextInt] == 0) {
                    queue.add(new Node(nextInt, now.cnt + 1));
                    visited[nextInt] = now.cnt + 1;
                }
            }

            // 네번째 숫자 바꾸기
            for(int i=0; i<=9; i++){
                String nextStr = str.substring(0, 3) + Integer.toString(i);
                int nextInt = Integer.parseInt(nextStr);

                if(!isPrime[nextInt] && visited[nextInt] == 0) {
                    queue.add(new Node(nextInt, now.cnt + 1));
                    visited[nextInt] = now.cnt + 1;
                }

            }
        }
    }
}