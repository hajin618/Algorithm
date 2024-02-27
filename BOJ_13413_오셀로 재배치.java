import java.io.*;
import java.util.*;

public class Main {

    static int T, N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){
            N = Integer.parseInt(br.readLine());
            String start = br.readLine();
            String end = br.readLine();

            int w = 0;
            int b = 0;

            for(int i=0; i<N; i++){
                if(start.charAt(i) != end.charAt(i)){
                    if(start.charAt(i) == 'W'){
                        w += 1;
                    }
                    else{
                        b += 1;
                    }
                }
            }
            sb.append(Math.max(w, b)).append("\n");
        }
        
        System.out.println(sb);
    }
}