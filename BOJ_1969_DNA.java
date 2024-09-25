import java.io.*;
import java.util.*;

public class Main {

    static int N, M, max, hd;
    static String[] s;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        s = new String[N];
        for(int i=0; i<N; i++){
            s[i] = br.readLine();
        }

        for(int i=0; i<M; i++){
            int a=0, t=0, g=0, c=0;
            for(int j=0; j<N; j++){
                char ch = s[j].charAt(i);

                if(ch == 'A') a += 1;
                else if(ch == 'T') t += 1;
                else if(ch == 'G') g += 1;
                else if(ch == 'C') c += 1;
            }
            max = Math.max(a>c?a:c, g>t?g:t);
            hd += (N-max);

            if(max == a) sb.append("A");
            else if(max == c) sb.append("C");
            else if(max == g) sb.append("G");
            else if(max == t) sb.append("T");
        }
        sb.append("\n").append(hd);
        System.out.print(sb);
    }
}