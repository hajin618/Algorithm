import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int L;
    public static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(true){
            boolean flag = false;

            for(int i=0; i<N; i++){
                if(L >= arr[i]){
                    arr[i] = Integer.MAX_VALUE;
                    L += 1;
                    flag = true;
                    break;
                }
            }

            if(!flag)
                break;
        }
        System.out.println(L);
    }
}