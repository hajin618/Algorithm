import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        int len = s.length();

        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if('A' <= c && c <= 'Z'){
                double d = arr[c - 'A'];
                stack.push(d);
            }
            else{
                double d1 = stack.pop();
                double d2 = stack.pop();
                double d3 = 0;

                if(c == '+') d3 = d2 + d1;
                else if(c == '-') d3 = d2 - d1;
                else if(c == '*') d3 = d2 * d1;
                else if(c == '/') d3 = d2 / d1;

                stack.push(d3);
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}