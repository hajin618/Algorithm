import java.io.*;
import java.util.*;

public class Main {
    static int D, K;
    static int[] cntA;
    static int[] cntB;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cntA = new int[31];
        cntB = new int[31];

        cntA[1] = 1;
        cntA[2] = 0;
        cntB[1] = 0;
        cntB[2] = 1;

        for(int i=3; i<=30; i++){
            cntA[i] = cntA[i-2] + cntA[i-1];
            cntB[i] = cntB[i-2] + cntB[i-1];
        }
        int a = 0;
        int b = 0;

        for(int i=1; i<=800000; i++){
            if((K - (i * cntA[D])) % cntB[D] == 0){
                a = i;
                b = (K - (i * cntA[D])) / cntB[D];
                break;
            }
        }

        System.out.println(a);
        System.out.println(b);
    }
}