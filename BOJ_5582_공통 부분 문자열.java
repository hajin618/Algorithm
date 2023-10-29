import java.io.*;
import java.util.*;

public class Main{

    static String s1, s2;
    static int[][] arr;
    static int ANS;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        s1 = br.readLine();
        s2 = br.readLine();

        arr = new int[s1.length() + 1][s2.length() + 1];

        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1] + 1;
                    ANS = Math.max(ANS, arr[i][j]);
                }
            }
        }

        System.out.println(ANS);
    }
}