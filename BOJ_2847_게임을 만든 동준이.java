import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int ANS = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int idx = N - 1;
        int now = arr[idx];

        while(true){
            if(idx == 0)
                break;

            idx -= 1;

            if(now <= arr[idx]){
                ANS += arr[idx] - now + 1;

                arr[idx] = now - 1;
            }
            now = arr[idx];
        }
        System.out.println(ANS);
    }
}