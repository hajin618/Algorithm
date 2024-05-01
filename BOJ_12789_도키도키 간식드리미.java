import java.io.*;
import java.util.*;

public class Main {

    static int N, now;
    static Stack<Integer> stack;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        stack = new Stack<>();
        now = 1;
        String result = "Nice";

        for(int i=0; i<N; i++){
            int n = arr[i];
            if(now != n){
                if(!stack.isEmpty() && now == stack.peek()){
                    now += 1;
                    stack.pop();
                    i -= 1;
                }
                else{
                    stack.push(n);
                }
            }
            else{
                now += 1;
            }
        }

        while(!stack.isEmpty()){
            int p = stack.pop();
            if(p == now){
                now += 1;
            }
            else{
                result = "Sad";
                break;
            }
        }

        System.out.println(result);
    }
}