import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int zero = 0;
        int one = 0;
        boolean[] available = new boolean[s.length()];

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                zero += 1;
            }
            else one += 1;
        }

        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1'){
                available[i] = true;
                cnt += 1;
            }

            if(cnt == one / 2)
                break;
        }

        cnt = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '0'){
                available[i] = true;
                cnt += 1;
            }

            if(cnt == zero / 2)
                break;
        }

        for(int i=0; i<s.length(); i++){
            if(!available[i])
                sb.append(s.charAt(i));
        }

        System.out.println(sb);
    }
}