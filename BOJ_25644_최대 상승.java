import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int MAX;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int buy = arr[0];
        for (int i = 1; i < N; i++) {
            MAX = Math.min(MAX, buy - arr[i]);

            if(buy > arr[i])
                buy = arr[i];
        }

        if(MAX > 0)
            System.out.println(0);
        else
            System.out.println(-MAX);
    }
}