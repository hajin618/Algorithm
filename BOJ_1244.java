import java.io.*;
import java.util.*;

public class Main {

    public static boolean[] switchArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        switchArr = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            if(Integer.parseInt(st.nextToken()) == 0)
                switchArr[i] = false;
            else switchArr[i] = true;
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());

        for(int i=0; i<S; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == 1){
                for(int p = b; p<N+1; p+=b)
                    switchArr[p] = !switchArr[p];
            }
            else if(a == 2) {
                switchArr[b] = !switchArr[b];
                int left = b - 1;
                int right = b + 1;

                if(left > 0 && right <= N) {
                    while (switchArr[left] == switchArr[right]) {
                        
                        switchArr[left] = !switchArr[left];
                        switchArr[right] = !switchArr[right];

                        left -= 1;
                        right += 1;

                        if (left <= 0 || right > N)
                            break;
                    }
                }
            }
        }
        int line = 0;
        for(int i=1; i<=N; i++){
            line += 1;

            if(switchArr[i] == false)
                System.out.print(0 + " ");
            else
                System.out.print(1 + " ");

            if(line == 20){
                System.out.println();
                line = 0;
            }
        }
    }
}