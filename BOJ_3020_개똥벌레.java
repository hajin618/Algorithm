import java.io.*;
import java.util.*;

public class Main {

    static int N, H, CNT, MIN;
    static int[] bottom, top;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        bottom = new int[H+1];
        top = new int[H+1];

        for(int i=0; i<N/2; i++){
            bottom[Integer.parseInt(br.readLine())] += 1;
            top[Integer.parseInt(br.readLine())] += 1;
        }

        for(int i=H-1; i>0; i--){
            bottom[i] += bottom[i+1];
            top[i] += top[i+1];
        }

        MIN = N;

        for(int i=H; i>0; i--){
            if(bottom[i] + top[H-i+1] < MIN){
                CNT = 1;
                MIN = bottom[i] + top[H-i+1];
            } else if(bottom[i] + top[H-i+1] == MIN){
                CNT += 1;
            }
        }

        System.out.println(MIN + " " + CNT);
    }
}