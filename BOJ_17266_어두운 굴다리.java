import java.io.*;
import java.util.*;

public class Main {

    static int N, M, ANS, prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int x = Integer.parseInt(st.nextToken());

            if(i == 0) ANS = (ANS < x - prev) ? x-prev : ANS;
            else{
                double tmp = Math.ceil(((double) x - (double) prev) /(double) 2);
                ANS = (ANS < tmp) ? (int)tmp : ANS;
            }
            prev = x;
        }
        ANS = (ANS < N - prev) ? N-prev : ANS;

        System.out.println(ANS);
    }
}