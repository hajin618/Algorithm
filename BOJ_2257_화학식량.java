import java.io.*;
import java.util.*;

public class Main {

    static String S;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        int len = S.length();

        arr = new int[100];
        int tmp = 0;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);

            if(c=='H') {
                tmp=1;
                arr[cnt] +=1;
            }else if(c=='C') {
                tmp=12;
                arr[cnt] +=12;
            }else if(c=='O') {
                tmp=16;
                arr[cnt] +=16;
            }else if(c=='(') {
                arr[++cnt]=0;
            }else if(c==')') {
                tmp = arr[cnt--];
                arr[cnt]+=tmp;
            }else if(c>'1' && c<='9') {
                arr[cnt]+=tmp*(c-'1');
            }
        }

        System.out.println(arr[0]);
    }
}