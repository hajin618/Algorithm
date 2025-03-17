import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int sum = 0;
        int cnt = 0;

        while(true){
            if(s.length() == 1){
                sum = Integer.parseInt(s);
                break;
            }

            sum = 0;
            for(int i=0; i<s.length(); i++){
                sum += s.charAt(i) - '0';
            }

            s = String.valueOf(sum);
            cnt += 1;
        }

        System.out.println(cnt);
        if(sum == 3 || sum == 6 || sum == 9)
            System.out.println("YES");
        else System.out.println("NO");
    }
}