import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        sb.append("<");
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            for(int i=0; i<K-1; i++){
                int a = queue.poll();
                queue.add(a);
            }
            sb.append(queue.poll());
            if(queue.size() != 0){
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}