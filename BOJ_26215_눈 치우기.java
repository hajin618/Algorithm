import java.io.*;
import java.util.*;

public class Main {

    static int N, ANS;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while(!pq.isEmpty()){
            int now = pq.poll();

            if(pq.isEmpty()){
                ANS += now;
                break;
            }

            int next = pq.poll();
            ANS += next;

            if(ANS > 1440){
                ANS = -1;
                break;
            }
            pq.add(now - next);
        }

        if(ANS > 1440){
            ANS = -1;
        }
        System.out.println(ANS);
    }
}