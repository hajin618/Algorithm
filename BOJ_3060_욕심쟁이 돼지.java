import java.io.*;
import java.util.*;

public class Main {

    static int T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){

            N = Integer.parseInt(br.readLine());
            int sum = 0;
            int day = 1;

            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=6; i++){
                sum += Integer.parseInt(st.nextToken());
            }

            while(true){
                if(sum > N)
                    break;

                sum *= 4;
                day += 1;
            }

            sb.append(day).append("\n");
        }

        System.out.print(sb);
    }
}