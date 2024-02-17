import java.io.*;
import java.util.*;

public class Main {

    static int N, Bcnt, Rcnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        Bcnt = 0;
        Rcnt = 0;
        char pre = 'a';

        for(int i=0; i<N; i++){
            char now = s.charAt(i);
            if(now != pre){
                if(now == 'R')
                    Rcnt += 1;
                else
                    Bcnt += 1;
            }

            pre = now;
        }

        System.out.println(Math.min(Bcnt, Rcnt) + 1);
    }
}