import java.io.*;
import java.util.*;

public class Main {

    static int H, W;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int now = -1;
        for(int i=0; i<H; i++){
            now = -1;
            String s = br.readLine();
            for(int j=0; j<W; j++){
                Character c = s.charAt(j);

                if(c == 'c'){
                    now = 0;
                }
                else{
                    if(now != -1)
                        now += 1;
                }

                sb.append(now).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}