import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String S;
    static long Num, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while((S = br.readLine()) != null){
            N = Integer.parseInt(S);

            Num = 1;
            cnt = 1;
            while(true){
                if(Num % N == 0){
                    System.out.println(cnt);
                    break;
                }
                else{
                    Num = (Num * 10) + 1;
                    Num %= N;
                    cnt += 1;
                }
            }
        }

    }
}