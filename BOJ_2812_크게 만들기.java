import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;

        for(int i=0; i<N; i++) {
            while(!stack.isEmpty() && stack.peek() < arr[i] - '0' && cnt < K) {
                stack.pop();
                cnt++;
            }
            stack.push(arr[i] - '0');
        }

        while(cnt < K) {
            stack.pop();
            cnt++;
        }
        for(int stk : stack) {
            sb.append(stk);
        }
        System.out.println(sb);
    }
}
