import java.io.*;
import java.util.*;

public class Main {

    static int N, ANS = 0;
    static Stack<Character> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){

            stack = new Stack<>();
            String s = br.readLine();

            int len = s.length();
            if(len % 2 == 1)
                continue;

            for(int j=0; j<len; j++){
                if(!stack.isEmpty() && stack.peek() == s.charAt(j))
                    stack.pop();
                else{
                    stack.push(s.charAt(j));
                }
            }

            if(stack.isEmpty())
                ANS += 1;
        }

        System.out.println(ANS);
    }
}