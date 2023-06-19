import java.io.*;
import java.util.*;

public class Main {

    static String S, T;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        S = br.readLine();
        T = br.readLine();

        while(S.length() != T.length()){
            if(T.charAt(T.length()-1) == 'A'){
                T = subLast(T);
            }
            else{
                T = subLast(T);
                T = reverse(T);
            }
        }

        if(S.equals(T))
            System.out.println(1);
        else
            System.out.println(0);

    }

    // 마지막 글자 제거
    public static String subLast(String s){
        return s.substring(0, s.length()-1);
    }

    // 뒤집기
    public static String reverse(String s){
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }
}