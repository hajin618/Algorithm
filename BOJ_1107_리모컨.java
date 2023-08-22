import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] broken, visited;
    static int ANS;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        broken = new boolean[10];
        visited = new boolean[1000000];

        if(M != 0){
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 1) 100
        if(N == 100){
            System.out.println(0);
        }
        else{
            // 2) 100 에서 시작
            ANS = Math.abs(N - 100);

            // 3) 완탐
            for(int i = 0; i<=999999; i++){
                String s = Integer.toString(i);
                boolean flag = false;
                int size = s.length();

                for(int j=0; j<size; j++){
                    char c = s.charAt(j);
                    if(broken[c - '0']){
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    int ans = Math.abs(N - i) + size;
                    ANS = Math.min(ans, ANS);
                }
            }

            System.out.println(ANS);
        }
    }

}