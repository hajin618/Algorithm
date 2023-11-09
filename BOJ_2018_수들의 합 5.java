import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int sum = 1;
        int left = 1;
        int right = 1;

        while(left <= right){

            if(sum == N){
                cnt += 1;
            }

            if(sum < N){
                right += 1;
                sum += right;
            }
            else if(sum >= N){
                sum -= left;
                left += 1;
            }

        }
        System.out.println(cnt);
    }
}