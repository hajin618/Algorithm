import java.io.*;
import java.util.*;

public class Main {

    static int N, M, start, end, J, ANS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(br.readLine());

        start = 1;
        end = start + M - 1;

        for(int i=0; i<J; i++){
            int a = Integer.parseInt(br.readLine());

            if(start <= a && a <= end){
                continue;
            }
            else if(start > a){
                ANS += start - a;
                start = a;
                end = start + M - 1;
            }
            else if(end < a){
                ANS += a - end;
                end = a;
                start = end - M + 1;
            }
        }

        System.out.println(ANS);
    }
}