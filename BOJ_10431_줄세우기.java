import java.io.*;
import java.util.*;

public class Main {

    static int P, ans;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        P = Integer.parseInt(br.readLine());

        for(int i=0; i<P; i++){
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());

            ans = 0;
            arr = new int[20];

            for(int j=0; j<20; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=1; j<20; j++){
                for(int k=j-1; k>=0; k--){
                    if(arr[k] > arr[j])
                        ans += 1;
                }
            }

            sb.append(no).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}