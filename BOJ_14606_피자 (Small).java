import java.io.*;
import java.util.*;

public class Main {
    static int N, ANS;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == 1)
                continue;

            int a, b;
            if(now % 2 == 0){
                a = now / 2;
                ANS += a * a;
                queue.add(a);
                queue.add(a);
            }
            else{
                a = now / 2;
                b = a + 1;
                ANS += a * b;
                queue.add(a);
                queue.add(b);
            }
        }
        System.out.println(ANS);
    }
}