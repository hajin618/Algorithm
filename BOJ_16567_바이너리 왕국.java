import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1 && !flag) {
                cnt++;
                flag = true;
            } else if (arr[i] == 0) {
                flag = false;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int trial = Integer.parseInt(st.nextToken());
            if (trial == 1){
                int index = Integer.parseInt(st.nextToken()) - 1;
                if (arr[index] == 1) continue;
                else arr[index] = 1;

                if (index == 0) {
                    if (arr[index + 1] == 0) cnt++;
                } 
                else if (index == N - 1) {
                    if (arr[index - 1] == 0) cnt++;
                } 
                else {
                    if (arr[index - 1] == 0 && arr[index + 1] == 0) {
                        cnt++;
                    } else if (arr[index - 1] == 1 && arr[index + 1] == 1) {
                        cnt--;
                    }
                }
            }
            else{
                sb.append(cnt).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}