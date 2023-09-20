import java.io.*;
import java.util.*;

public class Main{
    static int[] A, B;
    static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        A = new int[46];
        B = new int[46];

        A[0] = 1;
        B[0] = 0;

        for(int i=1; i<=45; i++){
            A[i] = B[i-1];
            B[i] = B[i-1] + A[i-1];
        }

        K = Integer.parseInt(br.readLine());

        System.out.println(A[K]+" "+B[K]);
    }
}