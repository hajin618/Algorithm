import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int tmp = K * (K+1) / 2;

        if(tmp > N)
            System.out.println(-1);
        else{
            if((N-tmp) % K == 0){
                System.out.println(K-1);
            }
            else{
                System.out.println(K);
            }
        }
    }
}